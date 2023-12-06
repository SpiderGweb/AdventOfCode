public class CalibrationCodeCalculator {
    public int extractCalibrationCode(String input) {
        String onlyDigits = input.replaceAll("[\\D]", "");
        return Integer.parseInt(onlyDigits);
    }
}
