package LinearFit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import Library.AlgoTools;

public class TestCase {
    public static void main(String[] args) {
        String filePath = "C:\\Code\\CSC310\\LinearFit\\NoisyLinearData.csv";
        String line = "";
        double[][] q = { { 0, 0 }, { 0, 0 } };
        double[][] u = { { 0 }, { 0 } };
        String outPath = "C:\\Code\\CSC310\\LinearFit\\processed.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                double xVal = Double.valueOf(data[0]);
                double yVal = Double.valueOf(data[1]);
                q[0][0]++;
                q[0][1] += xVal;
                q[1][0] += xVal;
                q[1][1] += xVal * xVal;
                u[0][0] += yVal;
                u[1][0] += xVal * yVal;
            }
            double[][] c = AlgoTools.matmult(AlgoTools.getInverse(q), u);
            AlgoTools.printMatrix(c);
            double[] poly = new double[] { 0.6625, -4.9622 };
            BufferedWriter proWriter = new BufferedWriter(new FileWriter(outPath));
            for (int i = 0; i <= 100; i++) {
                proWriter.write(Double.toString(AlgoTools.round(((i/5.0) - 10.0),2)) + ", " + Double.toString(AlgoTools.hornersMethod(poly, AlgoTools.round(((i/5.0) - 10.0),2))) + "\n");
            }
            proWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
