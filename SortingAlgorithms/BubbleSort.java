package SortingAlgorithms;

public class BubbleSort {
    public static void run(int[] toSort){
        int numberOfPairs = toSort.length;
        boolean swapped = true;
        while (swapped) {
            numberOfPairs -= 1;
            swapped = false;
            for (int i = 0; i < numberOfPairs; i++) {
                TestCase.buCount++;
                if(toSort[i] > toSort[i+1]){
                    int temp = toSort[i+1];
                    toSort[i+1] = toSort[i];
                    toSort[i] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void runMod(int[] toSort){

    }
}
