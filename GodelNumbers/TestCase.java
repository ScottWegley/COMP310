package GodelNumbers;

public class TestCase {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] mySequence = new int[] { 7, 6, 5, 4, 3, 2, 1 };
        GodelNumbering testClass = new GodelNumbering(mySequence);

        System.out.print("The Godel Number you got from the sequence ");
        for (int i : mySequence) {
            System.out.print(i + " ");
        }
        System.out.print("was " + testClass.geteNumber());

        System.out.print("\nThe reverse mapped sequence from " + testClass.geteNumber() + " is ");

        long[] sourceSequence = testClass.geteSourceSequence();
        for (long x : sourceSequence) {
            System.out.print(x + " ");
        }
        System.out.print("\n" + (System.currentTimeMillis() - start));
    }
}