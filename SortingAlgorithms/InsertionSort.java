package SortingAlgorithms;
public class InsertionSort {
    public static long internalCount = 0;
    public static long run(int[] toSort) {
        internalCount = 0;
        for (int i = 1; i < toSort.length; i++) {
            int newElement = toSort[i];
            int location = i - 1;
            internalCount++;
            while (location >= 0 && toSort[location] > newElement) {
                toSort[location + 1] = toSort[location];
                location -= 1;
                internalCount++;
            }
            toSort[location + 1] = newElement;
        }
        return internalCount;
    }

    public static void main(String[] args) {
        int[] myArr = new int[12];
        for (int index = 0; index < myArr.length; index++) {
            myArr[myArr.length - (index + 1)] = index;
            //myArr[index] = index;
        }
        FisherYates.run(myArr);
        run(myArr);
    }
}
