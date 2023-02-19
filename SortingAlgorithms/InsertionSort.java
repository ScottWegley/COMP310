package SortingAlgorithms;
public class InsertionSort {
    public static long internalCount = 0;
    public static void run(int[] toSort) {
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
    }

    public static void main(String[] args) {
        int[] myArr = new int[12];
        for (int index = 0; index < myArr.length; index++) {
            //myArr[myArr.length - (index + 1)] = index;
            myArr[index] = index;
        }
        run(myArr);
        for (int i = 0; i < myArr.length; i++) {
            System.out.println(myArr[i]);
        }
        System.out.println("C: " + internalCount);
    }
}
