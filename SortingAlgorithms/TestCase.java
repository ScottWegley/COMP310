package SortingAlgorithms;

public class TestCase {

    public static int N = 16;

    public static void main(String[] args) {
        // Monte Carlo
        System.out.println("Monte Carlo Stats");
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            int[] myArr1 = new int[SIZE];
            int[] myArr2 = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[i] = i;
                myArr1[i] = i;
                myArr2[i] = i;
            }
            FisherYates.run(myArr);
            FisherYates.run(myArr1);
            FisherYates.run(myArr2);
            System.out.println("L: 2^" + q + " C: " + InsertionSort.run(myArr) + "      " + BubbleSort.run(myArr1) + "       " + BubbleSort.run2(myArr2));
        }
        // Ascending Order
        System.out.println("Ascending Stats");
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            int[] myArr1 = new int[SIZE];
            int[] myArr2 = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[i] = i;
                myArr1[i] = i;
                myArr2[i] = i;
            }
            System.out.println("L: 2^" + q + " C: " + InsertionSort.run(myArr) + "      " + BubbleSort.run(myArr1) + "       " + BubbleSort.run2(myArr2));
        }
        // Descending Order
        System.out.println("Descending Stats");
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            int[] myArr1 = new int[SIZE];
            int[] myArr2 = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[myArr.length - i - 1] = i;
                myArr1[myArr1.length - i - 1] = i;
                myArr2[myArr2.length - i - 1] = i;
            }
            System.out.println("L: 2^" + q + " C: " + InsertionSort.run(myArr) + "      " + BubbleSort.run(myArr1) + "       " + BubbleSort.run2(myArr2));
        }
    }
}
