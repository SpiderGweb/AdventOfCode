import model.Game;
import model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameInspectorTest {
    GameInspector gameInspector;

    @BeforeEach
    public void init() {
        gameInspector = new GameInspector();
    }

    @Test
    public void isRoundValidDefaultsToFalse() {
        Round inputBag = new Round();

        assertEquals(false, gameInspector.isRoundValid(inputBag));
    }

    @Test
    public void parseGameSetsGameIdWhenItIsSingleDigit(){
        String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        Game game = gameInspector.parseGame(input);

        assertEquals(1, game.getId());
    }

    @Test
    public void parseGameSetsGameIdWhenItIsMultiDigit(){
        String input = "Game 356: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        Game game = gameInspector.parseGame(input);

        assertEquals(356, game.getId());
    }

}
