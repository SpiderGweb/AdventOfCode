import model.Game;
import model.Round;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameInspector {
    public boolean isRoundValid(Round exampleBag) {
        return false;
    }

    public Game parseGame(String input) {
        Game game = new Game();
        game.setId(getNumber(input));

        String[] rounds = input
                .substring(input.indexOf(":")+2)
                .split(";");

        game.setRounds(
                Arrays.stream(rounds)
                        .map(this::parseRound)
                        .toList()
        );

        return game;
    }


    private Round parseRound(String round){
        Round parsedRound = new Round();
        parsedRound.setBlue(getAmountForColor(round, "blue"));
        parsedRound.setRed(getAmountForColor(round, "red"));
        parsedRound.setGreen(getAmountForColor(round, "green"));
        return parsedRound;
    }

    private int getAmountForColor(String input, String color){
        Matcher colorMatcher = Pattern
                .compile("\\d+ "+color)
                .matcher(input);

        if (colorMatcher.find()){
            return getNumber(colorMatcher.group());
        } else return 0;

    }

    private int getNumber(String input) {
        Matcher matcher = Pattern
                .compile("\\d+")
                .matcher(input);

        matcher.find();
        return Integer.parseInt(matcher.group());
    }
}
