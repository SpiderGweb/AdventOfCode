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

    public boolean isRoundValid(Round exampleBag, Round control)
    {
        return exampleBag.getBlue() <= control.getBlue() &&
                exampleBag.getRed() <= control.getRed() &&
                exampleBag.getGreen() <= control.getGreen();
    }

    public int getGamePower(List<Round> rounds)
    {
        return rounds.get(0).getBlue() * rounds.get(0).getRed() * rounds.get(0).getGreen();
    }

}
