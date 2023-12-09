import model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameInspectorTest {
    GameInspector gameInspector;
    Round control;

    @BeforeEach
    public void init() {
        gameInspector = new GameInspector();
        control = new Round();
        control.setBlue(14);
        control.setRed(12);
        control.setGreen(13);
    }

    @Test
    public void sumIdsOfValidGamesReturnsIdOfValidGameWhenThereIsOneGameWithOneValidRound(){
        String[] input = {"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"};

        assertEquals(1, gameInspector.sumIdsOfValidGames(input, control));
    }

    @Test
    public void sumIdsOfValidGamesReturnsIdOfValidGameWhenThereIsOneGameWithMultipleRoundsAllValid(){
        String[] input = {"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"};

        assertEquals(1, gameInspector.sumIdsOfValidGames(input, control));
    }

    @Test
    public void sumIdsOfValidGamesReturnsIdOfValidGameWhenThereIsOneGameWithMultipleRoundsSomeNotValid(){
        String[] input = {"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 25 green"};

        assertEquals(0, gameInspector.sumIdsOfValidGames(input, control));
    }
    @Test
    public void sumIdsOfValidGamesReturnsIdOfValidGameWhenThereAreMultipleGames(){
        String[] input = {
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
        };

        assertEquals(8, gameInspector.sumIdsOfValidGames(input, control));
    }


    @Test
    public void isRoundValidIsTrueWhenRoundHasNoCubes() {
        Round inputBag = new Round();
        Round control = new Round();

        assertTrue(gameInspector.isRoundValid(inputBag, control));
    }

    @Test
    public void isRoundValidIsTrueWhenRoundHasFewerRedCubesThanTheControl() {
        Round inputBag = new Round();
        Round control = new Round();

        inputBag.setRed(1);
        control.setRed(5);

        assertTrue(gameInspector.isRoundValid(inputBag, control));
    }

    @Test
    public void isRoundValidIsTrueWhenRoundHasSameRedCubesThanTheControl() {
        Round inputBag = new Round();
        Round control = new Round();

        inputBag.setRed(5);
        control.setRed(5);

        assertTrue(gameInspector.isRoundValid(inputBag, control));
    }

    @Test
    public void isRoundValidIsTrueWhenRoundHasFewerGreenCubesThanTheControl() {
        Round inputBag = new Round();
        Round control = new Round();

        inputBag.setGreen(1);
        control.setGreen(5);

        assertTrue(gameInspector.isRoundValid(inputBag, control));
    }

    @Test
    public void isRoundValidIsTrueWhenRoundHasSameGreenCubesThanTheControl() {
        Round inputBag = new Round();
        Round control = new Round();

        inputBag.setGreen(5);
        control.setGreen(5);

        assertTrue(gameInspector.isRoundValid(inputBag, control));
    }

    @Test
    public void isRoundValidIsTrueWhenRoundHasFewerBlueCubesThanTheControl() {
        Round inputBag = new Round();
        Round control = new Round();

        inputBag.setBlue(1);
        control.setBlue(5);

        assertTrue(gameInspector.isRoundValid(inputBag, control));
    }

    @Test
    public void isRoundValidIsTrueWhenRoundHasSameBlueCubesThanTheControl() {
        Round inputBag = new Round();
        Round control = new Round();

        inputBag.setBlue(5);
        control.setBlue(5);

        assertTrue(gameInspector.isRoundValid(inputBag, control));
    }

}
