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
        internalCount++;
        if (first < last) {
            int pivot = PivotList(list, first, last, mode);
            QuickSort(list, first, pivot - 1, mode);
            QuickSort(list, pivot + 1, last, mode);
        }
    }

    private static int PivotList(int[] list, int first, int last, PivotMode mode) {
        if (mode == PivotMode.FIRST) {
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
        } else if (mode == PivotMode.LAST) {
            int PivotValue = list[last];
            int PivotPoint = (first - 1);
            for (int i = first; i < last; i++) {
                internalCount++;
                if (list[i] <= PivotValue) {
                    PivotPoint++;
                    int temp = list[PivotPoint];
                    list[PivotPoint] = list[i];
                    list[i] = temp;
                }
            }
            int temp = list[PivotPoint + 1];
            list[PivotPoint + 1] = list[last];
            list[last] = temp;
            return PivotPoint + 1;
        } else {
            int pivot = (int) Math.random() * (last - first) + first;
            int temp = list[pivot];
            list[pivot] = list[last];
            list[last] = temp;
            int PivotValue = list[last];
            int PivotPoint = (first - 1);
            for (int i = first; i < last; i++) {
                internalCount++;
                if (list[i] < PivotValue) {
                    PivotPoint++;
                    int temp1 = list[PivotPoint];
                    list[PivotPoint] = list[i];
                    list[i] = temp1;
                }
            }
            int temp1 = list[PivotPoint + 1];
            list[PivotPoint + 1] = list[last];
            list[last] = temp1;
            return PivotPoint + 1;
        }
    }

    public static void main(String[] args) {
        int[] myArr = new int[] { 7, 6, 5, 4, 22, 4, 3, 1, 0, -20, 44, 55, 10 };
        run(myArr, PivotMode.RANDOM);
        for (int i : myArr) {
            System.out.println(i);
        }
    }
}
