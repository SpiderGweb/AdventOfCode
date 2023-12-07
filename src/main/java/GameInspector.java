import model.Game;
import model.Round;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameInspector {
    public boolean isRoundValid(Round exampleBag) {
        return false;
    }

    public Game parseGame(String input) {
        Game game = new Game();
        game.setId(getId(input));

        return  game;
    }

    private int getId(String input){
        Matcher matcher = Pattern
                .compile("\\d+")
                .matcher(input);

        matcher.find();
        return Integer.parseInt(matcher.group());
    }
}
