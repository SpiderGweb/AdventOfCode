import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    @Test
    public void calculateCalibrationCodeReturnsFirstAndLastDigitEvenWhenSpelled() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String input = "two1nine";


        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input), 29);
    }

    @Test
    public void calculateCalibrationCodeReturnsFirstAndLastDigitForInputThatIsOnlyWords() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String input = "eightwothree";


        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input), 83);
    }

    @Test
    public void calculateCalibrationCodeReturnsFirstAndLastDigitForInputThatIsCommbo() {
        CalibrationCodeCalculator calibrationCodeCalculator = new CalibrationCodeCalculator();

        String input = "abcone2threexyz";
        String input1 = "xtwone3four";
        String input2 = "4nineeightseven2";
        String input3 = "zoneight234";
        String input4 = "7pqrstsixteen";


        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input), 13);
        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input1), 24);
        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input2), 42);
        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input3), 14);
        assertEquals(calibrationCodeCalculator.extractCalibrationCode(input4), 76);
    }

    @Test
    public void calculateCalibrationCodeFromFile() throws Exception{
        Scanner sc = new Scanner(new File("src/test/resources/calibration_codes.txt"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] input = lines.toArray(new String[0]);
        System.out.print(calibrationCodeCalculator.sumCalibrationCodes(input));

        assertEquals(calibrationCodeCalculator.sumCalibrationCodes(input), 53312);
    }
}
