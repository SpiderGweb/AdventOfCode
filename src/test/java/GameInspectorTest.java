import model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameInspectorTest {
    GameInspector gameInspector;

    @BeforeEach
    public void init() {
        gameInspector = new GameInspector();
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

}
