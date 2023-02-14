package SearchAlgorithms;

public class BinarySearch {

    public static int run(int[] list, int key) {
        int start = 0;
        int end = list.length;
        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            switch (compare(key, list[middle])) {
                case -1:
                    end = middle - 1;
                    break;
                case 0:
                    return middle;
                case 1:
                    start = middle + 1;
                    break;
            }
        }
        return -1;
    }

    /**
     * A function to compare two values in the context of a search.
     * @param key The value you are looking for.
     * @param check The value you are checking against.
     * @return 0 if the values are equal.  -1 if the value you are checking against is greater than the search target.  1 if the search target is greater than the value you are checking against.
     */
    private static int compare(int key, int check){
        TestCase.binaryCount++;
        if(check > key){
            return -1;
        }
        if(key > check){
            return 1;
        }
        return 0;
    }
}
