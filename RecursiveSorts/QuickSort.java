package RecursiveSorts;

public class QuickSort {

    public static long internalCount = 0L;

    public static long run(int[] toSort) {
        internalCount = 0L;
        QuickSort(toSort, 0, toSort.length - 1);
        return internalCount;
    }

    private static void QuickSort(int[] list, int first, int last) {
        internalCount++;
        if (first < last) {
            int pivot = PivotList(list, first, last);
            QuickSort(list, first, pivot - 1);
            QuickSort(list, pivot + 1, last);
        }
    }

    private static int PivotList(int[] list, int first, int last) {
        int PivotValue = list[first];
        int PivotPoint = first;
        for (int i = first + 1; i <= last; i++) {
            internalCount++;
            if(list[i] < PivotValue){
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
        int[] myArr = new int[]{7,6,5,4,22,4,3,1,0,-20,44,55,10};
        run(myArr);
        for (int i : myArr) {
            System.out.println(i);
        }
    }
}
