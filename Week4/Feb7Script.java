package Week4;

import java.util.Random;

public class Feb7Script {

    public static int N = 101;
    public static int count = 0;
    public static Random r;

    public static int linearSearch(int[] toSearch, int key) {
        for (int i = 0; i < toSearch.length; i++) {
            count++;
            if (toSearch[i] == (key))
                return i;
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[N];

        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        

        System.out.println((double)count/N);
    }

}
