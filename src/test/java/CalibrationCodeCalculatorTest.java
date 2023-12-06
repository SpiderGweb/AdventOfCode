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
    public void sumCalibrationCodesReturnsCodeWhenInputHasLength1() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String[] input = {"pqr3stu8vwx"};

        assertEquals(calibrationCodeCalculator.sumCalibrationCodes(input), 38);
    }

    @Test
    public void sumCalibrationCodesReturnsCodeWhenInputIsMultiline() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String[] input = {"1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"};

        assertEquals(calibrationCodeCalculator.sumCalibrationCodes(input), 142);
    }

    @Test
    public void calculateCalibrationCodeReturnsIntegerOfConcatenatedFirstAndLastDigitOfStringWithTwoDigits() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String input = "15";

        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input), 15);
    }

    @Test
    public void calculateCalibrationCodeReturnsIntegerOfConcatenatedFirstAndLastDigitOfStringWithTwoDigitsThatHaveTextAroundThem() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String input = "some1text9here";

        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input), 19);
    }

    @Test
    public void calculateCalibrationCodeReturnsIntegerOfConcatenatedFirstAndLastDigitOfStringWithManyDigits() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String input = "8some9text5here2";

        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input), 82);
    }

    @Test
    public void calculateCalibrationCodeReturnsRepeatedDigitWhenInputHasOnlyOneDigit() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String input = "treb7uchet";

        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input), 77);
    }

}
