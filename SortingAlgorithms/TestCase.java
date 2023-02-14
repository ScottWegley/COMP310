package SortingAlgorithms;

public class TestCase {

    public static long inCount = 0;
    public static long buCount = 0;
    public static int bu2Count = 0;
    public static int N = 20;
    static double[] inStats = new double[20];
    static double[] buStats = new double[20];
    static double[] bu2Stats = new double[20];

    public static void main(String[] args) {
        for (int q = 0; q <= N; q++) {
            int SIZE = (int) Math.pow(2, q);
            int[] myArr = new int[SIZE];
            for (int i = 0; i < myArr.length; i++) {
                myArr[i] = (int) Math.round(Math.random() * SIZE);
            }
            int[] myArr2 = myArr;
            InsertionSort.run(myArr);
            BubbleSort.run(myArr2);
            inStats[q] = inCount ;
            buStats[q] =  buCount ;
            // bu2Stats[q] = (double) bu2Count / N;
        }
        System.out.println("Inersertion Stats");
        for (int i = 0; i < N; i++) {
            System.out.println("L: " + Math.pow(2,i) + " C: " + inStats[i]);
        }
        System.out.println("Bubble Stats");
        for (int i = 0; i < N; i++) {
            System.out.println("L: " + Math.pow(2,i) + " C: " + buStats[i]);
        }

    }
}
