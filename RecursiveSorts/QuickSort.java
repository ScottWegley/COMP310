package RecursiveSorts;

public class QuickSort {

    public static long internalCount = 0L;

    public enum PivotMode {
        FIRST,
        LAST,
        RANDOM;
    }

    public static long run(int[] toSort, PivotMode mode) {
        internalCount = 0L;
        QuickSort(toSort, 0, toSort.length - 1, mode);
        return internalCount;
    }

    private static void QuickSort(int[] list, int first, int last, PivotMode mode) {
        if (first < last) {
            int pivot = PivotList(list, first, last, mode);
            QuickSort(list, first, pivot - 1, mode);
            QuickSort(list, pivot + 1, last, mode);
        }
    }

    private static int PivotList(int[] list, int first, int last, PivotMode mode) {
        if (mode != PivotMode.FIRST) {
            int index = (mode == PivotMode.RANDOM ? (int) (Math.random() * (last - first)) + first : last);
            int temp = list[first];
            list[first] = list[index];
            list[index] = temp;
        }
        int PivotValue = list[first];
        int PivotPoint = first;
        for (int i = first + 1; i <= last; i++) {
            internalCount++;
            if (list[i] < PivotValue) {
                PivotPoint++;
                int temp = list[PivotPoint];
                list[PivotPoint] = list[i];
                list[i] = temp;
            }
        }
        int temp = list[first];
        list[first] = list[PivotPoint];
        list[PivotPoint] = temp;
        return PivotPoint;
    }

    public static void main(String[] args) {
        // int[] myArr = new int[(int) Math.pow(2, 4)];
        int[] myArr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        /*
         * for (int i = 0; i < myArr.length; i++) {
         * myArr[i] = i;
         * }
         */
        FisherYates.run(myArr);
        System.out.println("C:  " + run(myArr, PivotMode.RANDOM));
        for (int i : myArr) {
            System.out.println(i);
        }
    }
}
