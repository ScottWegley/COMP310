package BinarySearch;

public class BinarySearch {

    public static int run(int[] list, int key) {
        return -1;
    }

    /**
     * A function to compare two values in the context of a search.
     * @param key The value you are looking for.
     * @param check The value you are checking against.
     * @return 0 if the values are equal.  -1 if the value you are checking against is greater than the search target.  1 if the search target is greater than the value you are checking against.
     */
    private static int compare(int key, int check){
        TestCase.count++;
        if(check > key){
            return -1;
        }
        TestCase.count++;
        if(key > check){
            return 1;
        }
        return 0;
    }
}
