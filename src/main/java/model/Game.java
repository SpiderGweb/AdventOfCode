package model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private int id;
    private List<Round> rounds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public Game(String input) {
        this.id = getNumber(input);

        String[] rounds = input
                .substring(input.indexOf(":") + 2)
                .split(";");

        this.rounds = Arrays.stream(rounds)
                .map(this::parseRound)
                .toList();
    }


    private Round parseRound(String round) {
        Round parsedRound = new Round();
        parsedRound.setBlue(getAmountForColor(round, "blue"));
        parsedRound.setRed(getAmountForColor(round, "red"));
        parsedRound.setGreen(getAmountForColor(round, "green"));

        return parsedRound;
    }

    private int getAmountForColor(String input, String color) {
        Matcher colorMatcher = Pattern
                .compile("\\d+ " + color)
                .matcher(input);

        if (colorMatcher.find()) {
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
