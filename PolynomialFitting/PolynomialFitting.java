package PolynomialFitting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Library.AlgoTools;

public class PolynomialFitting {
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

        return AlgoTools.matmult(AlgoTools.getInverse(Q),U);
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
        while (--b > 0) {
            result *= a;
        }
        return result;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Code\\CSC310\\PolynomialFitting\\NoisyLinearData.csv";
        ArrayList<double[]> dataSet = new ArrayList<>();
        String line = "";
        System.out.println(qpow(2, 3));
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                dataSet.add(new double[] { Double.valueOf(data[0]), Double.valueOf(data[1]) });
            }
            br.close();
            double[][] myArr = new double[dataSet.size()][2];
            dataSet.toArray(myArr);

            AlgoTools.printMatrix(fitPolynomial(myArr, 1));
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
