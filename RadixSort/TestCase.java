package RadixSort;

public class TestCase {

    public static char[] dictionary = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };

    public static void main(String[] args) {
        String[] unsorted = { "zero", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen", "twenty" };
        padArray(unsorted, maxSize(unsorted));
        String[] temp = {"test", "array", "please", "ignore"};
        padArray(temp, maxSize(temp));
        radixSort(temp, maxSize(temp));
        for (String string : temp) {
            System.out.println(string);
        }
    }

    public static int maxSize(String[] list) {
        int len = 0;
        for (String item : list) {
            if (item.length() > len) {
                len = item.length();
            }
        }
        return len;
    }

    public static void padArray(String[] list, int size) {
        for (int i = 0; i < list.length; i++) {
            while (list[i].length() < size) {
                list[i] += " ";
            }
        }
    }

    public static void radixSort(String[] list, int maxSize) {
        int shift = 1;
        int N = list.length;
        String[][] buckets = new String[27][N]; // Each character can store up to N occurrence
        int[] bucketCounts;
        for (int i = 0; i < maxSize; i++) {
            bucketCounts = new int[27];
            for (int entry = 0; entry < N; entry++) {
                int bucketNumber = dictionaryIndex(list[entry].charAt(i));
                buckets[bucketNumber][bucketCounts[bucketNumber]++] = list[entry];
            }
            list = CombineBuckets(buckets, bucketCounts, N);
        }
    }

    public static String[] CombineBuckets(String[][] buckets, int bucketCounts[], int N){
        String[] combineBuckets = new String[N];
        int j = 0;
        for (int bn = 0; bn < buckets.length; bn++) {
            for (int i = 0; i < bucketCounts[bn]; i++) {
                combineBuckets[j++] = buckets[bn][i];
            }
        }
        return combineBuckets;
    }

    public static int dictionaryIndex(char c) {
        for (int i = 0; i < dictionary.length; i++) {
            if(dictionary[i] == c) return i;
        }
        return dictionary.length;
    }

    public static void radixSort(int[] list) {
        int N = list.length;
        int[][] buckets = new int[10][N];
        int[] bucketCounts;
        int keySize = 10;
        int shift = 1;
        for (int loop = 0; loop < keySize; loop++) {
            bucketCounts = new int[10];
            for (int entry = 0; entry < N - 1; entry++) {
                int bucketNumber = (list[entry] / shift) % 10;
                buckets[bucketNumber][bucketCounts[bucketNumber]++] = list[entry];
            }
            list = CombineBuckets(buckets, bucketCounts, N);
            shift *= 10;
        }
    }

    public static int[] CombineBuckets(int[][] buckets, int bucketCounts[], int N) {
        int[] combinedBuckets = new int[N];
        int j = 0;
        for (int bn = 0; bn < buckets.length; bn++) {
            for (int i = 0; i < bucketCounts[bn]; i++) {
                combinedBuckets[j++] = i;
            }
        }
        return combinedBuckets;
    }
}
