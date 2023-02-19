package SortingAlgorithms;

public class TestCase {

    public static int N = 5;

    public static void main(String[] args) {
        // Monte Carlo
        /*
         System.out.println("Monte Carlo Stats");
         for (int q = 0; q <= N; q++) {
         int SIZE = (int) Math.pow(2, q);
         int[] myArr = new int[SIZE];
         for (int i = 0; i < myArr.length; i++) {
         myArr[i] = i;
         }
         FisherYates.run(myArr);
         int[] myArr1 = myArr;
         int[] myArr2 = myArr;
         InsertionSort.run(myArr);
         BubbleSort.run(myArr1);
         BubbleSort.run2(myArr2);
         inStats[q] = InsertionSort.internalCount;
         buStats[q] = BubbleSort.internalCount;
         bu2Stats[q] = BubbleSort.internalCount2;
         }
         */
        // Ascending Order
        System.out.println("Ascending Stats");
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[i] = i;
            }
            int[] myArr1 = myArr;
            int[] myArr2 = myArr;
            InsertionSort.run(myArr);
            BubbleSort.run(myArr1);
            BubbleSort.run2(myArr2);
        }
        // Descending Order
        System.out.println("Descending Stats");
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[SIZE - 1 - i] = i;
            }
            int[] myArr1 = myArr;
            int[] myArr2 = myArr;
            InsertionSort.run(myArr);
            BubbleSort.run(myArr1);
            BubbleSort.run2(myArr2);
        }
    }
}
