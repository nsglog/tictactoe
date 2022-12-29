import factories.BotDifficultyLevelFactory;
import factories.GameWinningStrategyNameEnumFactory;
import factories.PlayerFactory;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of players");
        int numberOfPlayers = scanner.nextInt();

        System.out.println("Enter number of Bots");
        int numberOfBots = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        for(int i = 0; i < numberOfBots; ++i) {

            System.out.println("Enter name of bot "+(i+1));
            String botName = scanner.next();

            System.out.println("Symbol of bot "+(i+1));
            Character character = scanner.next().charAt(0);

            System.out.println("Difficulty of bot " +(i+1));
            String difficultyLevel = scanner.next();

            BotDifficultyLevel botDifficultyLevel = BotDifficultyLevelFactory.getBotDifficultyLevelByName(difficultyLevel);

            players.add(PlayerFactory.createBot(botName, character, botDifficultyLevel));
        }

        for(int i = numberOfBots; i < numberOfPlayers; ++i) {

            System.out.println("Enter name of player " +(i - numberOfBots + 1));
            String name = scanner.next();

            System.out.println("Symbol of player " +(i - numberOfBots + 1));
            Character character = scanner.next().charAt(0);

            players.add(PlayerFactory.createHumanPlayer(name, character));
        }

        System.out.println("Enter number of winning strategies");
        Integer winningStrategiesCount = scanner.nextInt();

        List<GameWinningStrategyName> gameWinningStrategyNames = new ArrayList<>();

        for(int i = 0 ;i < winningStrategiesCount; ++i) {

            System.out.println("Name strategy " + (i + 1));
            gameWinningStrategyNames.add(GameWinningStrategyNameEnumFactory.getGameWinningStrategyNameFromString(scanner.next()));
        }

        Game game = Game.getbuilder().setGameWinningStrategies(gameWinningStrategyNames).setPlayers(players).build();

        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS))  {
            game.makeMove();
        }
    }
}