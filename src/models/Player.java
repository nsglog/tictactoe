package models;

import java.util.Scanner;

public class Player {

    private Symbol symbol;
    private PlayerType playerType;
    private String name;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Move makeMove(Board board)   {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row to make move (0 indexed) ");
        int row = scanner.nextInt();
        System.out.println("Enter column to make move");
        int col = scanner.nextInt();

        Move move = new Move(row, col, this);

        return move;
    }
}
