public class CalibrationCodeCalculator {
    public int sumCalibrationCodes(String[] input){
        int sum = 0;
        for (String line: input){
            sum += extractCalibrationCode(line);
        }
       return sum;
    }

    public int extractCalibrationCode(String input) {
        String onlyDigits = input.replaceAll("[\\D]", "");
        String calibrationCode = "" + onlyDigits.charAt(0) + onlyDigits.charAt(onlyDigits.length() -1);
        return Integer.parseInt(calibrationCode);
    }
}
