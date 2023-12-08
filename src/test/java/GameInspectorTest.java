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

}
