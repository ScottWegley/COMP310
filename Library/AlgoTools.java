package Library;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AlgoTools {
    public static double[][] matmult(double[][] arr1, double[][] arr2) throws IllegalArgumentException {
        if (arr1[0].length != arr2.length)
            throw new IllegalArgumentException();
        double[][] result = new double[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                double sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static double[][] getInverse(double[][] mat) throws IllegalArgumentException {
        int n = mat.length;
        if (n != mat[0].length)
            throw new IllegalArgumentException("Matrix must be a square");
        double[][] identity = new double[n][n];
        for (int i = 0; i < n; i++) {
            identity[i][i] = 1;
        }

        for (int k = 0; k < n; k++) {
            int pivotloc = k;
            double pivot = mat[pivotloc][pivotloc];
            try {
                while (Math.abs(pivot) < 0.0000001) {
                    pivot = mat[++pivotloc][pivotloc];
                }
                swapRows(mat, k, pivotloc);
                swapRows(identity, k, pivotloc);
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Matrix must have a determinant");
            }
            for (int j = 0; j < n; j++) {
                mat[k][j] /= pivot;
                identity[k][j] /= pivot;
            }
            for (int ii = 0; ii < n; ii++) {
                if (k == ii)
                    continue;
                double multipler = mat[ii][k];
                for (int j = 0; j < n; j++) {
                    mat[ii][j] -= multipler * mat[k][j];
                    identity[ii][j] -= multipler * identity[k][j];
                }
            }
        }
        return identity;
    }

    private static void swapRows(double[][] A, int r1, int r2){
        for (int i = 0; i < A[r1].length; i++) {
            double temp = A[r1][i];
            A[r1][i] = A[r2][i];
            A[r2][i] = temp;
        }
    }

    public static void printMatrix(double[][] A){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] > 0) {
                    System.out.print(" ");
                }
                System.out.printf("%.4f", A[i][j]);
                System.out.print("   ");
            }
            System.out.print("\n");
        }
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

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}