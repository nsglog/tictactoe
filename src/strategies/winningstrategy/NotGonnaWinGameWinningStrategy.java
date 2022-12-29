package strategies.winningstrategy;

import models.Board;
import models.Move;

public class NotGonnaWinGameWinningStrategy implements GameWinningStrategy {

    @Override
    public boolean checkVictory(Board board, Move lastMove) {
        return false;
    }
}
