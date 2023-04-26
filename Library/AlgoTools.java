package Library;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * Returns a polynomial fit to a provided data set.
     * 
     * @param data   An array of x,y values to fit a polynomial to.
     * @param degree The degree of the resultant polynomial.
     * @return
     * @throws IllegalArgumentException
     */
    public static double[][] fitPolynomial(double[][] data, int degree) throws IllegalArgumentException {
        if (degree <= 0) {
            throw new IllegalArgumentException("Degree must be greater than 0");
        }
        double[][] Q = new double[degree + 1][degree + 1];
        double[][] U = new double[degree + 1][1];
        Q[0][0] = data.length;
        // This loop iterates over the data set.
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != 2) {
                throw new IllegalArgumentException("Data set is incorrectly sized");
            }
            double xVal = data[i][0];
            double yVal = data[i][1];
            U[0][0] += yVal;
            // This loop iterates through the Q matrix.
            for (int pos = 1; pos <= degree; pos++) {
                for (int altPos = 0; altPos <= pos; altPos++) {
                    Q[pos][altPos] += qpow(xVal, pos + altPos);
                    Q[altPos][pos] += (pos == altPos ? 0 : qpow(xVal, pos + altPos));
                }
            }
            // This loop iterates through the U matrix.
            for (int pos = 1; pos <= degree; pos++) {
                U[pos][0] += yVal * qpow(xVal, pos);
            }
        }

        return matmult(getInverse(Q), U);
    }

    /**
     * A quick power function to save on computations.
     * 
     * @param a The base value.
     * @param b The exponent value.
     * @return The base value "a" raised to the exponent value "b."
     */
    private static double qpow(double a, double b) {
        double result = a;
        double sign = b / Math.abs(b);
        if (sign < 0) {
            b *= -1;
        }
        while (--b > 0) {
            result *= a;
        }
        if (sign < 0) {
            result = 1 / result;
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

    private static void swapRows(double[][] A, int r1, int r2) {
        for (int i = 0; i < A[r1].length; i++) {
            double temp = A[r1][i];
            A[r1][i] = A[r2][i];
            A[r2][i] = temp;
        }
    }

    public static void printMatrix(double[][] A) {
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
        if (places < 0)
            throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void reverseArray(double[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            double temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {

    }

    public static void printQueue(Queue<Integer> _q) {
        Queue<Integer> q = new PriorityQueue<>();
        q.addAll(_q);
        if (q.size() != 0) {
            System.out.print("Q: " + q.remove());
            while (!q.isEmpty()) {
                System.out.print(", " + q.remove());
            }
            System.out.print('\n');
        }
    }

    public static void printMatrix(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.printf("%d", A[i][j]);
                System.out.print("   ");
            }
            System.out.print("\n");
        }
    }

    public static void printListArray(ArrayList<Integer>[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i].isEmpty()) {
                continue;
            }
            System.out.print((i + 1) + ": " + A[i].get(0));
            for (int j = 1; j < A[i].size(); j++) {
                System.out.print(", " + A[i].get(j));
            }
            System.out.print('\n');
        }
    }

    public static <T> void printArrayList(ArrayList<T> arr){
        if(arr.size() == 0){
            return;
        }
        System.out.print("List: " + arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            System.out.print(", " + arr.get(i));
        }
        System.out.print('\n');
    }

    public static <T> void printGenAdjacencyList(HashMap<T, ArrayList<T>> map) {
        for (Map.Entry<T, ArrayList<T>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            if (entry.getValue().size() == 0) {
                System.out.print('\n');
                continue;
            }
            System.out.print(entry.getValue().get(0));
            for (int i = 1; i < entry.getValue().size(); i++) {
                System.out.print(", " + entry.getValue().get(i));
            }
            System.out.print('\n');
        }
    }

}