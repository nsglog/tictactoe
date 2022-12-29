package factories;

import models.*;
import strategies.winningstrategy.GameWinningStrategy;
import strategies.winningstrategy.NotGonnaWinGameWinningStrategy;

public class GameWinningStrategyFactory {

    public static GameWinningStrategy getGameWinningStrategyByName (GameWinningStrategyName gameWinningStrategyName)    {
        return new NotGonnaWinGameWinningStrategy();
    }
}
