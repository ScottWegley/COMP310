package Week9;

public class Mar16Script {
    public static double[][] matmult(int[][] A, int[][] B) throws IllegalArgumentException {
        if (A[0].length != B.length)
            throw new IllegalArgumentException();
        double[][] result = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                double sum = 0;
                for (int k = 0; k < B.length; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int[][] arr2 = { { 1, 5 }, { 2, 6 }, { 3, 7 }, { 4, 8 } };
        double[][] arr3 = matmult(arr1, arr2);

        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[0].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
