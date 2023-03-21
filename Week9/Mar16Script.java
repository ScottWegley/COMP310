package Week9;

public class Mar16Script {
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

    public static void main(String[] args) {
        double[][] arr1 = { { 2, -4, 6 }, { 6, -6, 6 }, { 4, 2, 2 } };
        double[][] arr2 = { { -0.2, 1.0/6.0, 0.1 }, { 0.1, -1.0/6.0, 0.2 }, { 0.3, -1.0/6.0, 0.1 } };
        double[][] arr3 = matmult(arr1, arr2);

        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[0].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
