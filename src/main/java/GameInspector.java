import model.Game;
import model.Round;

public class GameInspector {
    public  int sumIdsOfValidGames(String[] rounds, Round control){
        Game game = new Game(rounds[0]);
        if(isRoundValid(game.getRounds().get(0), control ) ) return game.getId(); else return 0; }

    public boolean isRoundValid(Round exampleBag, Round control)
    {
        return exampleBag.getBlue() <= control.getBlue() &&
                exampleBag.getRed() <= control.getRed() &&
                exampleBag.getGreen() <= control.getGreen();
    }

}
