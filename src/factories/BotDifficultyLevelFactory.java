package factories;

import models.BotDifficultyLevel;

public class BotDifficultyLevelFactory {

    public static BotDifficultyLevel getBotDifficultyLevelByName (String name)  {
        if(name.equals("EASY")) {
            return BotDifficultyLevel.EASY;
        }

        else if(name.equals("MEDIUM"))  {
            return BotDifficultyLevel.MEDIUM;
        }

        return BotDifficultyLevel.HARD;
    }
}
