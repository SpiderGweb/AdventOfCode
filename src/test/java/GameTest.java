import model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    GameInspector gameInspector;

    @BeforeEach
    public void init() {
        gameInspector = new GameInspector();
    }


    @Test
    public void parseGameSetsGameIdWhenItIsSingleDigit() {
        String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        Game game = new Game(input);

        assertEquals(1, game.getId());
    }

    @Test
    public void parseGameSetsGameIdWhenItIsMultiDigit() {
        String input = "Game 356: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        Game game = new Game(input);

        assertEquals(356, game.getId());
    }


    @Test
    public void parseGameSetsParsesRoundWhenThereIsASingleRoundOfASingleColor() {
        String input = "Game 356: 3 blue";
        Game game = new Game(input);

        assertEquals(1, game.getRounds().size());
        assertEquals(3, game.getRounds().get(0).getBlue());
        assertEquals(0, game.getRounds().get(0).getRed());
        assertEquals(0, game.getRounds().get(0).getGreen());
    }

    @Test
    public void parseGameSetsParsesRoundWhenThereIsASingleRoundOfManyColors() {
        String input = "Game 356: 6 blue, 4 red";
        Game game = new Game(input);

        assertEquals(1, game.getRounds().size());
        assertEquals(6, game.getRounds().get(0).getBlue());
        assertEquals(4, game.getRounds().get(0).getRed());
        assertEquals(0, game.getRounds().get(0).getGreen());
    }

    @Test
    public void parseGameSetsParsesRoundWhenThereAreMultipleRoundsOfMultipleColors() {
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
        Game game = new Game(input);

        assertEquals(4, game.getId());
        assertEquals(3, game.getRounds().size());

        assertEquals(6, game.getRounds().get(0).getBlue());
        assertEquals(3, game.getRounds().get(0).getRed());
        assertEquals(1, game.getRounds().get(0).getGreen());

        assertEquals(0, game.getRounds().get(1).getBlue());
        assertEquals(6, game.getRounds().get(1).getRed());
        assertEquals(3, game.getRounds().get(1).getGreen());;

        assertEquals(15, game.getRounds().get(2).getBlue());
        assertEquals(14, game.getRounds().get(2).getRed());
        assertEquals(3, game.getRounds().get(2).getGreen());
    }

}
