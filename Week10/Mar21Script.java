package Week10;

public class Mar21Script {

    public static double[][] getInverse(double[][] mat) throws IllegalArgumentException {
        int n = mat.length;
        if (n != mat[0].length)
            throw new IllegalArgumentException("Matrix must be a square");
        double[][] inverse = new double[n][n];
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
                if(k==ii) continue;
                double multipler = mat[ii][k];
                for (int j = 0; j < n; j++) {
                    mat[ii][j] -= multipler * mat[k][j];
                    identity[ii][j] -= multipler * identity[k][j];
                }
            }
        }

        for (int k = n - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                double factor = mat[i][k];
                for (int j = 0; j < n; j++) {
                    mat[i][j] -= factor * mat[k][j];
                    identity[i][j] -= factor * identity[k][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = identity[i][j];
            }
        }
        return inverse;
    }

    private static void swapRows(double[][] A, int r1, int r2){
        for (int i = 0; i < A[r1].length; i++) {
            double temp = A[r1][i];
            A[r1][i] = A[r2][i];
            A[r2][i] = temp;
        }
    }

    public static void main(String[] args) {
        double[][] matrix = new double[][] { { 2, -4, 6 }, { 6, -6, 6 }, { 4, 2, 2 } };
        double[][] inverse = getInverse(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j < inverse.length; j++) {
                if (inverse[i][j] > 0) {
                    System.out.print(" ");
                }
                System.out.printf("%.4f", inverse[i][j]);
                System.out.print("   ");
            }
            System.out.print("\n");
        }
    }
}
