package factories;

import models.GameWinningStrategyName;

public class GameWinningStrategyNameEnumFactory {

    public static GameWinningStrategyName getGameWinningStrategyNameFromString (String name )   {

        if(name.equals("ROW"))  {
            return GameWinningStrategyName.ROW;
        }

        else if(name.equals("COLUMN"))  {
            return GameWinningStrategyName.COLUMN;
        }

        else if(name.equals("DIAGONAL"))    {
            return GameWinningStrategyName.DIAGONAL;
        }

        return GameWinningStrategyName.CORNER;
    }
}
