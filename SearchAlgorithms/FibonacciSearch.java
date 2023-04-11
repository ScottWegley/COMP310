package SearchAlgorithms;

public class FibonacciSearch {
    // -- derived from https://www.geeksforgeeks.org/fibonacci-search/
    public static int run(int[] list, int target) {
        int N = list.length;

        // -- degenerate case
        TestCase.fibCount++;
        if (N == 1 && list[N - 1] == target)
            return N - 1;

        // --Initialize fibonacci numbers
        int m2 = 0;
        int m1 = 1;
        int m = 1;

        // -- find the smallest fibonacci number greater than or
        // equal to the list size (along with the
        // two previous fibonacci numbers)
        while (m < N) {
            m2 = m1;
            m1 = m;
            m = m2 + m1;
        }

        // -- keep track of the discarded elements of the front of the list
        // initially they are all kept
        int start = -1;

        // -- search for the target value within the interval
        // [m2..N]
        while (m > 1) {
            // -- is m2 within the list bounds?
            int index = (start + m2 < N - 1) ? start + m2 : N - 1;

            // -- if the target is greater than the value at m2 + offset
            // drop the lower portion of the array (the target is not there)
            TestCase.fibCount++;
            if (target > list[index]) {
                m = m1;
                m1 = m2;
                m2 = m - m1;
                start = index;
            }
            // -- else if the target is less than the value at m2 + offset
            // drop the upper portion of the array (the target is not there)
            else {
                if (target < list[index]) {
                    m = m2;
                    m1 = m1 - m2;
                    m2 = m - m1;
                } else {
                    return index;
                }
            }
        }

        // -- target was not in the list
        return -1;
    }

    public static void main(String[] args) {
        int[] myArr = new int[100];
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = i;
        }

        System.out.println(run(myArr, 12));
    }

}
