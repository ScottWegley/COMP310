package RadixSort;

public class TestCase {

    public static char[] dictionary = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        String[] unsorted = { "zero", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen", "twenty" };
        padArray(unsorted, maxSize(unsorted));
        unsorted = radixSort(unsorted, maxSize(unsorted));
        for (String string : unsorted) {
            System.out.println(string + "|");
        }
    }

    public static String[] radixSort(String[] list, int maxLen){
        int N = list.length;
        int keySize = maxLen;
        String[][] bucket = new String[27][N];
        for (int i = 0; i < keySize; i++) {
            int[] bucketCount = new int[27];
            for (int j = 0; j < N; j++) {
                int bn = dictionaryIndex(list[j].charAt(maxLen - 1 - i));
                bucket[bn][bucketCount[bn]++] = list[j];
            }
            list = mergeBuckets(bucket, bucketCount, N);
        }
        return list;
    }

    private static String[] mergeBuckets(String[][] buckets, int[] bucketCount, int N) {
        String[] result = new String[N];
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int k = 0; k < bucketCount[i]; k++) {
                result[j++] = buckets[i][k];
            }
        }
        return result;
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

    public static int dictionaryIndex(char c) {
        for (int i = 0; i < dictionary.length; i++) {
            if(dictionary[i] == c) return i;
        }
        return dictionary.length;
    }
}
