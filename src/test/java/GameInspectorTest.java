import model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameInspectorTest {
    GameInspector gameInspector;

    @BeforeEach
    public void init() {
        gameInspector = new GameInspector();
    }

    @Test
    public void isRoundValidDefaultsToFalse() {
        Round inputBag = new Round();

        assertFalse(gameInspector.isRoundValid(inputBag));
    }

}
