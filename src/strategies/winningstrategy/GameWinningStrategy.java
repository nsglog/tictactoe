package strategies.winningstrategy;

import models.Board;
import models.Move;

public interface GameWinningStrategy {

    boolean checkVictory (Board board, Move lastMove);
}
