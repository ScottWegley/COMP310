package SortingAlgorithms;
public class InsertionSort {
    public static void run(int[] toSort) {
        for (int i = 1; i < toSort.length; i++) {
            int newElement = toSort[i];
            int location = i - 1;
            TestCase.inCount++;
            while (location >= 0 && toSort[location] > newElement) {
                toSort[location + 1] = toSort[location];
                location -= 1;
            }
            toSort[location + 1] = newElement;
            TestCase.inCount++;
        }
    }
}
