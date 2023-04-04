package PolynomialFitting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

        return AlgoTools.matmult(AlgoTools.getInverse(Q), U);
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

    public static void main(String[] args) {
        String filePath = "C:\\Code\\CSC310\\PolynomialFitting\\NoisyPolynomialData.csv";
        ArrayList<double[]> dataSet = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                dataSet.add(new double[] { Double.valueOf(data[0]), Double.valueOf(data[1]) });
            }
            br.close();
            double[][] myArr = new double[dataSet.size()][2];
            dataSet.toArray(myArr);
            double[][] outputSet = new double[myArr.length][9];
            double[][][] matrixResults = new double[8][][];
            double[][] polynomials = new double[7][];
            for (int degIndex = 1; degIndex <= 7; degIndex++) {
                matrixResults[degIndex] = fitPolynomial(myArr, degIndex);
                double[] poly = new double[matrixResults[degIndex].length]; 
                for (int i = 0; i < matrixResults[degIndex].length; i++) {
                    for (int j = 0; j < matrixResults[degIndex][i].length; j++) {
                        poly[i] = matrixResults[degIndex][i][j];
                    }
                }

                AlgoTools.reverseArray(poly);
                polynomials[degIndex-1] = poly;
                System.out.println("Polynomial of Degree " + (degIndex));
                for (double d : poly) {
                    System.out.print(d + " ");
                }
                System.out.print("\n");
            }
            for (int i = 0; i < myArr.length; i++) {
                outputSet[i][0] = myArr[i][0];
                outputSet[i][1] = myArr[i][1];
                for (int j = 2; j < outputSet[i].length; j++) {
                    outputSet[i][j] = AlgoTools.hornersMethod(polynomials[j-2], outputSet[i][0]);
                }
            }
            
            BufferedWriter[] theWriters = new BufferedWriter[7];
            String partialPath = "C:\\Code\\CSC310\\PolynomialFitting\\degree";
            for (int i = 0; i < theWriters.length; i++) {
                theWriters[i] = new BufferedWriter(new FileWriter(partialPath + (i+1) + ".csv"));
            }

            for (int i = 0; i < outputSet.length; i++) {
                for (int j = 0; j < theWriters.length; j++) {
                    theWriters[j].write(Double.toString(outputSet[i][0])+","+Double.toString(outputSet[i][1]) + ",");
                }
                for (int j = 2; j < outputSet[i].length; j++) {
                    theWriters[j-2].write(Double.toString(AlgoTools.round(outputSet[i][j],3)) + "\n");
                }
            }

            for (int i = 0; i < theWriters.length; i++) {
                theWriters[i].close();
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
