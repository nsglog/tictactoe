package models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cell>> board;

    public Cell getCell(int row, int col)   {
        return board.get(row).get(col);
    }

    public Board(int dimenson) {
        this.dimension = dimenson;
        this.board = new ArrayList<>();

        for(int i=0; i<dimenson; ++i)   {

            this.board.add(new ArrayList<>());

            for(int j=0; j<dimenson; ++j)   {

                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void display() {

        for(List<Cell> row : board) {

            for(Cell cell : row)   {

                if(cell.getPlayer() == null)  {
                    System.out.print(" - ");
                }
                else {
                    System.out.print(" "+cell.getPlayer().getSymbol().getCharacter() + " ");
                }
            }

            System.out.print("\n");
        }

    }

}
