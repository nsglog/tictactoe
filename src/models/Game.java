package models;

import exceptions.DuplicateSymbolException;
import factories.GameWinningStrategyFactory;
import strategies.winningstrategy.GameWinningStrategy;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;
    private int filledCells;

    private Game () {}

    public static Builder getbuilder () {
        return new Builder();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }

    public int getLastMovedPlayerIndex() {
        return lastMovedPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setGameWinningStrategies (List<GameWinningStrategyName> gameWinningStrategyNames)    {
            this.gameWinningStrategies = new ArrayList<GameWinningStrategy>();

            for (GameWinningStrategyName gameWinningStrategyName: gameWinningStrategyNames) {
                this.gameWinningStrategies.add(GameWinningStrategyFactory.getGameWinningStrategyByName(gameWinningStrategyName));
            }
            return this;
        }

        public Game build () {

            Set<Character> alreadyExistingCharacter = new HashSet<>();

            for(Player player : players)   {

                if(alreadyExistingCharacter.contains(player.getSymbol().getCharacter())) {
                    throw new DuplicateSymbolException(player.getSymbol().getCharacter());
                }
                alreadyExistingCharacter.add(player.getSymbol().getCharacter());
            }

            Game game = new Game();

            game.gameStatus = GameStatus.IN_PROGRESS;
            game.gameWinningStrategies = gameWinningStrategies;
            game.players = players;
            game.moves = new ArrayList<>();
            game.board = new Board(players.size() + 1);
            game.lastMovedPlayerIndex = -1;

            return game;
        }
    }

    public void makeMove() {

        board.display();

        this.lastMovedPlayerIndex += 1;
        this.lastMovedPlayerIndex %= players.size();

        System.out.println(this.players.get(lastMovedPlayerIndex).getName() + "'s turn ");

        Move checkMove = this.players.get(this.lastMovedPlayerIndex).makeMove(this.board);

        if(this.board.getCell(checkMove.getRow(), checkMove.getCol()).getPlayer() != null)  {
            System.out.println("Bad move try again !");
            return;
        }

        this.moves.add(checkMove);

        this.board.getCell(checkMove.getRow(), checkMove.getCol()).setPlayer(this.players.get(lastMovedPlayerIndex));

        filledCells += 1;

        for(GameWinningStrategy gameWinningStrategy : gameWinningStrategies)    {
            if(gameWinningStrategy.checkVictory(board, checkMove)) {
                gameStatus = GameStatus.ENDED;
                winner = this.players.get(lastMovedPlayerIndex);
                return;
            }
        }

        if(filledCells == (this.players.size() + 1) * (this.players.size() + 1)) {
            gameStatus = GameStatus.DRAW;
        }
    }
}
