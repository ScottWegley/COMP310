package RecursiveSorts;

public class FisherYates {
    public static void run(int[] toAlter) {
        for (int i = 0; i < toAlter.length - 2; i++) {
            int j = (int) Math.round(Math.random() * (toAlter.length - 1));
            int temp = toAlter[i];
            toAlter[i] = toAlter[j];
            toAlter[j] = temp;
        }
        return;
    }
}
