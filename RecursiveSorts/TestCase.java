package RecursiveSorts;

import RecursiveSorts.QuickSort.PivotMode;

public class TestCase {

    public static int N = 13;

    public static void main(String[] args) {
        System.out.println("Monte Carlo Stats");
        System.out.println("        Merge, Quick1, Quick2, Quick3");
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            int[] myArr1 = new int[SIZE];
            int[] myArr2 = new int[SIZE];
            int[] myArr3 = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[i] = i;
                myArr1[i] = i;
                myArr2[i] = i;
                myArr3[i] = i;
            }
            FisherYates.run(myArr);
            FisherYates.run(myArr1);
            System.out.println("L: 2^" + q + " C: " + MergeSort.run(myArr) + "      " + QuickSort.run(myArr1, PivotMode.FIRST) + "      " + QuickSort.run(myArr2, PivotMode.LAST) + "      " + QuickSort.run(myArr3, PivotMode.RANDOM));
        }
        System.out.println("Ascending Stats");
        System.out.println("        Merge, Quick1, Quick2, Quick3");
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            int[] myArr1 = new int[SIZE];
            int[] myArr2 = new int[SIZE];
            int[] myArr3 = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[i] = i;
                myArr1[i] = i;
                myArr2[i] = i;
                myArr3[i] = i;
            }
            System.out.println("L: 2^" + q + " C: " + MergeSort.run(myArr) + "      " + QuickSort.run(myArr1, PivotMode.FIRST) + "      " + QuickSort.run(myArr2, PivotMode.LAST) + "      " + QuickSort.run(myArr3, PivotMode.RANDOM));
        }
        System.out.println("Descending Stats");
        System.out.println("        Merge, Quick1, Quick2, Quick3");
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            int[] myArr1 = new int[SIZE];
            int[] myArr2 = new int[SIZE];
            int[] myArr3 = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[myArr.length - 1 - i] = i;
                myArr1[myArr1.length - 1 - i] = i;
                myArr2[myArr2.length - 1 - i] = i;
                myArr3[myArr3.length - 1 - i] = i;
            }
            System.out.println("L: 2^" + q + " C: " + MergeSort.run(myArr) + "      " + QuickSort.run(myArr1, PivotMode.FIRST) + "      " + QuickSort.run(myArr2, PivotMode.LAST) + "      " + QuickSort.run(myArr3, PivotMode.RANDOM));
        }
    }
}
