package BinarySearch;

public class TestCase {

    private static int N = 5;
    public static int count = 0;

    public static void main(String[] args) {
        for (int q = 4; q < 20; q += 2) {
            count = 0;
            N = q;
            int[] myArr = new int[N];
            for (int i = 0; i < myArr.length; i++) {
                myArr[i] = i;
            }
            for (int i = 0; i < myArr.length; i++) {
                BinarySearch.run(myArr, i);
            }
            System.out.println("avg. comparisons for length " + N + ": " + (double) count / N);
        }
    }
}
