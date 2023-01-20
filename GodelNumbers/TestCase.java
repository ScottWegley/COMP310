package GodelNumbers;

public class TestCase {
    public static void main(String[] args) {
        int[] mySequence = new int[] {6,5,4,3,2,1 };
        GodelNumbering testClass = new GodelNumbering(mySequence);

        System.out.print("The Godel Number you got was " + testClass.geteNumber() + " from the sequence ");
        for (int i : mySequence) {
            System.out.print(i + " ");
        }

        if (true) {
            System.out.print("\nBy Godel Numbering, the sequence reversed from " + testClass.geteNumber() + " is ");

            long[] sourceSequence = testClass.geteSourceSequence();
            for (long factor : sourceSequence) {
                System.out.print(factor + " ");
            }
        }
    }
}