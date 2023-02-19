package SortingAlgorithms;

public class BubbleSort {
    public static long internalCount = 0;
    public static long internalCount2= 0;
    public static long run(int[] toSort) {
        internalCount = 0;
        int numberOfPairs = toSort.length;
        boolean swapped = true;
        while (swapped) {
            numberOfPairs -= 1;
            swapped = false;
            for (int i = 0; i < numberOfPairs; i++) {
                internalCount++;
                if (toSort[i] > toSort[i + 1]) {
                    int temp = toSort[i + 1];
                    toSort[i + 1] = toSort[i];
                    toSort[i] = temp;
                    swapped = true;
                }
            }
        }
        return internalCount;
    }

    public static long run2(int[] toSort) {
        internalCount2 = 0;
        int lower = 0;
        int upper = toSort.length - 1;

        while (true) {
            int lastSwap = upper;
            for (int i = upper; i > lower; i--) {
                internalCount2++;
                if (toSort[i] < toSort[i - 1]) {
                    int temp = toSort[i - 1];
                    toSort[i - 1] = toSort[i];
                    toSort[i] = temp;
                    lastSwap = i;
                }
            }
            lower = lastSwap;
            if(lower == upper){
                break;
            }
            for (int i = lower; i < upper; i++) {
                internalCount2++;
                if (toSort[i] > toSort[i + 1]) {
                    int temp = toSort[i + 1];
                    toSort[i + 1] = toSort[i];
                    toSort[i] = temp;
                    lastSwap = i;
                }
            }
            upper = lastSwap;
            if(lower == upper){
                break;
            }
        }
        return internalCount2;
    }

    public static void main(String[] args) {
        int[] myArr = new int[(int)Math.pow(2,5)];
        for (int i = 0; i < myArr.length; i++) {
            // myArr[i] = i;
            myArr[myArr.length - 1 - i] = i;
        }
        // FisherYates.run(myArr);
        System.out.println("C: " + run2(myArr));
    }
}
