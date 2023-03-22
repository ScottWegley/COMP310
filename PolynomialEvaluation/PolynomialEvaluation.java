package PolynomialEvaluation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PolynomialEvaluation {

    public static void main(String[] args) {
        double[] regular = new double[201];
        double[] horners = new double[201];
        double[] poly = new double[] { 1, 4, 0, 8, 6, 9, 2, 3 }; // x^7 + 4x^6 + 0x^5 + 8x^4 + 6x^3 + 9x^2 + 2x + 3
        double[][] preProcessedPoly = new double[][] {{1,0,0,0,5},{1,0,1},{1,4},{-1,4},{1,0,1},{1,-11},{1,-26}};
        //(x^4 + 0x^3 + 0x^2 + 0x + 5) * [(x^2 + 0x + 1) * (x + 4) + (-x + 4)] + [(x^2 + 0x + 1) * (x - 11) + (x - 26)]
        try {
            for (int i = 0; i <= 200.0; i += 1) {
                regular[i] = evaluate(poly, round(((i/5.0) - 20.0),2));
                horners[i] = hornersMethod(preProcessedPoly[0], round(((i/5.0) - 20.0),2)) * (hornersMethod(preProcessedPoly[1], round(((i/5.0) - 20.0),2))*hornersMethod(preProcessedPoly[2], round(((i/5.0) - 20.0),2))+hornersMethod(preProcessedPoly[3], round(((i/5.0) - 20.0),2))) + (hornersMethod(preProcessedPoly[4], round(((i/5.0) - 20.0),2))*hornersMethod(preProcessedPoly[5], round(((i/5.0) - 20.0),2))+hornersMethod(preProcessedPoly[6], round(((i/5.0) - 20.0),2)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Evaluate a polynomial in the form of a1x^n+a2x^n-1...+ax^0
     * 
     * @param coeffs An array of the coefficients in order from greatest power to
     *               least power (a1,a2,a3), including 0's for missing degrees.
     * @param x      The value of x to solve for.
     * @return The result when the specified x is plugged into the equation.
     */
    public static float evaluate(double[] coeffs, double x) {
        float result = (float) (coeffs[coeffs.length - 1] + coeffs[coeffs.length - 2] * x);
        double xPower = x;
        for (int i = 2; i < coeffs.length; i++) {
            xPower *= x;
            result += coeffs[coeffs.length - 1 - i] * xPower;
        }
        return result;
    }

    /**
     * Evaluate a polynomial in the form of a1x^n+a2x^n-1...+ax^0
     * 
     * @param coeffs An array of the coefficients in order from greatest power to
     *               least power (a1,a2,a3), including 0's for missing degrees.
     * @param x      The value of x to solve for.
     * @return The result when the specified x is plugged into the equation.
     */
    public static double hornersMethod(double[] coeffs, double x) {
        double result = coeffs[0];
        for (int i = coeffs.length - 2; i >= 0; i--) {
            result *= x;
            result += coeffs[coeffs.length - 1 - i];
        }
        return result;
    }

    /**
     * Evaluate a polynomial in the form of a1x^n+a2x^n-1...+ax^0. The highest
     * degree must be one less than a power of two.
     * 
     * @param coeffs An array of the coefficients in order from greatest power to
     *               least power (a1,a2,a3), including 0's for missing degrees.
     * @param x      The value of x to solve for.
     * @return The result when the specified x is plugged into the equation.
     */
    // public static double preProcessedCoeffs(double[] coeffs, double x){
    // double k = Math.log(coeffs.length)/Math.log(2);
    // double j = Math.pow(2,k-1);
    // double b = coeffs[(int) (j)] - 1;
    // System.out.println("x^" + j + " + " + b);
    // double[] divisor = new double[(int) (coeffs.length-j+1)];
    // divisor[0] = 1;
    // divisor[divisor.length-1] = b;
    // double[] quotient = new double[(int) (coeffs.length-j)];

    // System.out.println("a");
    // return b;
    // }
    // Will probably hopefully never use.

}