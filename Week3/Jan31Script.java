package Week3;

import java.util.Random;

public class Jan31Script {

    static Random random = new Random();
    static int N = 1000000000;
    static int Y = 6;

    public static void main(String[] args) {
        double rolls[] = new double[Y];

        for (int i = 0; i < N; i++) {
            int q = rollXSidedDie(Y);
            rolls[q - 1]++;
        }

        double sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        double probabilities[] = new double[Y];

        double probabilitiesSum = 0;
        
        for (int i = 0; i < probabilities.length; i++) {
            probabilities[i] = rolls[i]/sum;
            probabilitiesSum += probabilities[i];
            System.out.println(i + "'s: " + (int)rolls[i] + "  Probability: " + probabilities[i]);
        }
        System.out.println("Sum: " + (int)sum + " Probability: " + probabilitiesSum);
    }

    /**
     * Returns a random number between 1 and x.
     * 
     * @param x The inclusive upper bound for the random number.
     */
    public static int rollXSidedDie(int x) {
        return random.nextInt(x) + 1;
    }
}
