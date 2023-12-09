import model.Game;
import model.Round;

import java.util.List;

public class GameInspector {
    public  int sumIdsOfValidGames(String[] games, Round control){
        int sum = 0;
        for(String gameInput : games){
            Game game = new Game(gameInput);

            boolean gameValid = true;

            for(Round round : game.getRounds()){
                if(!isRoundValid(round, control)){
                    gameValid = false;
                    break;
                }
            }
            if(gameValid ) sum+=game.getId();
        }

        return sum;
    }

    public  int sumPowerOfGames(String[] games){
        int sum = 0;

        for(String gameInput : games){
            Game game = new Game(gameInput);
            sum+=getGamePower(game.getRounds());
        }

        return sum;
    }

    public boolean isRoundValid(Round exampleBag, Round control)
    {
        return exampleBag.getBlue() <= control.getBlue() &&
                exampleBag.getRed() <= control.getRed() &&
                exampleBag.getGreen() <= control.getGreen();
    }

    public int getGamePower(List<Round> rounds)
    {
        int maxBlue = 0;
        int maxRed = 0;
        int maxGreen = 0;

        for(Round round : rounds){
            if(round.getBlue() > maxBlue) maxBlue = round.getBlue();
            if(round.getRed() > maxRed) maxRed = round.getRed();
            if(round.getGreen() > maxGreen) maxGreen = round.getGreen();
        }

        return maxBlue * maxRed * maxGreen;
    }

}
