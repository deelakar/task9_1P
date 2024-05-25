package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result.
     * @param number1
     * @param number2
     * @return
     */
    public static Double q1Addition(String number1, String number2) {
        try {
            double result = Double.valueOf(number1) + Double.valueOf(number2);
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Calculate Q2 result.
     * @param number1
     * @param number2
     * @return
     */
    public static Double q2Subtraction(String number1, String number2) {
        try {
            double result = Double.valueOf(number1) - Double.valueOf(number2);
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
