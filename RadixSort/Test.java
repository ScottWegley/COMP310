package RadixSort;

class Test {

    public static void main(String[] args) {
        int[] test = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        radixSort(test);
        for (int i : test) {
            System.out.println(i);
        }
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