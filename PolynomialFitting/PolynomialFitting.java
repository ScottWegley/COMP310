package PolynomialFitting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PolynomialFitting {
    /**
     * Returns a polynomial fit to a provided data set.
     * @param data An array of x,y values to fit a polynomial to.
     * @param degree The degree of the resultant polynomial.
     * @return
     * @throws IllegalArgumentException
     */
    public static double[][] fitPolynomial(double[][] data, int degree) throws IllegalArgumentException{
        if(degree <= 0){
            throw new IllegalArgumentException("Degree must be greater than 0");
        }
        for (int i = 0; i < data.length; i++) {
            if(data[i].length != 2){
                throw new IllegalArgumentException("Data set is incorrectly sized");
            }
        }

        return new double[2][2];
    }

    public static void main(String[] args) {
        String filePath = "C:\\Code\\CSC310\\PolynomialFitting\\NoisyLinearData.csv";
        ArrayList<double[]> dataSet = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                dataSet.add(new double[]{Double.valueOf(data[0]),Double.valueOf(data[1])});
            }
            br.close();
            double[][] myArr = new double[dataSet.size()][2];
            dataSet.toArray(myArr);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
