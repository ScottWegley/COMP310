package SearchAlgorithms;

public class TestCase {

    private static int N = 0;
    public static int binaryCount = 0;
    public static int fibCount = 0;
    static int binResult, fibResult;
    static double[][] binStats = new double[21][2];
    static double[][] fibStats = new double[21][2];

    public static void main(String[] args) {
        for (int q = 0; q <= 20; q += 1) {
            binResult = 0;
            fibResult = 0;
            binaryCount = 0;
            fibCount = 0;
            N = (int) Math.pow(2,q);
            int[] myArr = new int[N];
            for (int i = 0; i < myArr.length; i++) {
                myArr[i] = i;
            }
            for (int i = 0; i < myArr.length; i++) {
                if(BinarySearch.run(myArr, i) == -1){
                    binResult++;
                }
                if(FibonacciSearch.run(myArr, i) == -1){
                    fibResult++;
                }
            }
            if(BinarySearch.run(myArr, -1) == -1){
                binResult++;
            };
            if(FibonacciSearch.run(myArr, -1) == -1){
                fibResult++;
            };
            binStats[q][0] = (double) binaryCount / N ;
            binStats[q][1] = binResult;
            fibStats[q][0] = (double) fibCount / N;
            fibStats[q][1] = fibResult;
        }
        System.out.println("Binary Stats");
        for (int i = 0; i <= 20; i++) {
            System.out.println("L: " + Math.pow(2,i) + " C: " + binStats[i][0] + " with " + binStats[i][1] + " misses.");
        }
        System.out.println("Fibonacci Stats");
        for (int i = 0; i <= 20; i++) {
            System.out.println("L: " + Math.pow(2,i) + " C: " + fibStats[i][0] + " with " + fibStats[i][1] + " misses.");
        }
    }
}
