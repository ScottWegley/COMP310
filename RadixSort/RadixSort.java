package RadixSort;

class RadixSort {

    public static void main(String[] args) {
        int[] test = new int[10];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) Math.round(Math.random() * 1000 - 1);
        }
        test = radixSort(test);
        for (int i : test) {
            System.out.println(i);
        }
    }

    public static int[] radixSort(int[] list) {
        int shift = 1;
        int N = list.length;
        int keySize = 3;
        int[][] bucket = new int[10][N];
        for (int i = 1; i <= keySize; i++) {
            int[] bucketCount = new int[10];
            for (int j = 0; j < N; j++) {
                int bn = (list[j] / shift) % 10;
                bucket[bn][bucketCount[bn]++] = list[j];
            }
            list = mergeBuckets(bucket, bucketCount, N);
            shift *= 10;
        }
        return list;
    }

    public static int[] mergeBuckets(int[][] buckets, int[] bucketCount, int N) {
        int[] result = new int[N];
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int k = 0; k < bucketCount[i]; k++) {
                result[j++] = buckets[i][k];
            }
        }
        return result;
    }

}