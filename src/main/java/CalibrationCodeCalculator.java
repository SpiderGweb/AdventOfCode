public class CalibrationCodeCalculator {
    public int sumCalibrationCodes(String[] input) {
        int sum = 0;
        for (String line : input) {
            sum += extractCalibrationCode(line);
        }
        return sum;
    }

    public int extractCalibrationCode(String input) {
        String onlyDigits = input.replaceAll("zero", "zero0zero");
        onlyDigits = onlyDigits
                .replaceAll("one", "one1one")
                .replaceAll("two", "two2two")
                .replaceAll("three", "three3three")
                .replaceAll("four", "four4four")
                .replaceAll("five", "five5five")
                .replaceAll("six", "six6six")
                .replaceAll("seven", "seven7seven")
                .replaceAll("eight", "eight8eight")
                .replaceAll("nine", "nine9nine")
                .replaceAll("[\\D]", "");

        String calibrationCode = "" + onlyDigits.charAt(0) + onlyDigits.charAt(onlyDigits.length() - 1);
        return Integer.parseInt(calibrationCode);
    }
}
