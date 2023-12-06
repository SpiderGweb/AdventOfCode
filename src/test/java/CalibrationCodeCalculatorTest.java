import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalibrationCodeCalculatorTest {
    CalibrationCodeCalculator calibrationCodeCalculator;

    @BeforeEach
    public void init() {
        calibrationCodeCalculator = new CalibrationCodeCalculator();
    }

    @Test
    public void calculateCalibrationCodeReturnsIntegerOfConcatenatedFirstAndLastDigitOfSingleLineWithTwoDigits() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String input = "15";

        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input), 15);
    }
}
