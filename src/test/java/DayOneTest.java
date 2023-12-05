import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOneTest {

    @Test
    public void calculateCalibrationCodeDefaultsToZero() {
        DayOne dayOne = new DayOne();

        assertEquals(dayOne.calculateCalibrationCode(), 0);
    }
}
