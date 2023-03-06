package RecursiveSorts;

public class MergeSort {

    public static long internalCount = 0L;

    public static long run(int[] toSort) {
        internalCount = 0L;
        MergeSort(toSort, 0, toSort.length - 1);
        return internalCount;
    }

    private static void MergeSort(int[] list, int first, int last){
        // internalCount++;
        if(first < last){
            int middle = (first + last) / 2;
            MergeSort(list, first, middle);
            MergeSort(list, middle + 1, last);
            MergeLists(list, first, middle, middle + 1, last);
        }
    }

    private static void MergeLists(int[] list, int startA, int endA, int startB, int endB) {
        int finalStart = startA;
        int finalEnd = endB;
        int indexC = 0;
        int[] result = new int[finalEnd - finalStart + 1];
        while(startA <= endA && startB <= endB){
            internalCount++;
            if(list[startA] < list[startB]){
                result[indexC] = list[startA];
                startA++;
            } else {
                result[indexC] = list[startB];
                startB++;
            }
            indexC++;
        }
        // internalCount++;
        if(startA <= endA){
            for (int i = startA; i <= endA; i++) {
                result[indexC] = list[i];
                indexC++;
            }
        } else {
            for (int i = startB; i <= endB; i++) {
                result[indexC] = list[i];
                indexC++;
            }
        }
        indexC = 0;
        for (int i = finalStart; i <= finalEnd; i++) {
            list[i] = result[indexC];
            indexC++;
        }
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{6, 2, 4, 7, 1, 3, 8, 5};
        System.out.println("C:   " + run(myArr));
        for (int i : myArr) {
            System.out.println(i);
        }
    }
}
