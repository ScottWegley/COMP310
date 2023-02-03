
class Probabilities {

    public static int N2 = 1500000000;
    public static int N3 = 1500000000;
    public static int N4 = 2;

    public static void problem2() {
        Dice diceA = new Dice(5);
        int[] aResults = new int[5];
        for (int i = 0; i < N2; i++) {
            aResults[diceA.roll() - 1]++;
        }
        System.out.println("5-Sided Dice Rolled " + N2 + " Times");
        for (int i = 0; i < aResults.length; i++) {
            System.out.println((i + 1) + ": " + String.format("%04.3f", (((float) (aResults[i]) / N2) * 100)) + "% || "
                    + aResults[i] + " Times");
        }

        Dice diceB = new Dice(5);
        int[] bResults = new int[9];
        for (int i = 0; i < N2; i++) {
            bResults[diceA.roll() + diceB.roll() - 2]++;
        }
        System.out.println("\nTwo 5-Sided Dice Rolled " + N2 + " Times & Summed");
        for (int i = 0; i < bResults.length; i++) {
            System.out.println((i + 2) + ": " + (i + 2 < 10 ? " " : "") + (bResults[i] < N2 / 10 ? "0" : "")
                    + String.format("%04.3f", (((float) (bResults[i]) / N2) * 100)) + "% || " + bResults[i] + " Times");
        }
    }

    public static void problem3() {
        Dice diceA = new Dice(new int[] { 1, 2, 3, 3, 4, 5, 5, 5 });
        int[] aResults = new int[5];
        for (int i = 0; i < N3; i++) {
            aResults[diceA.roll() - 1]++;
        }

        System.out.println("5-Sided Dice Rolled " + N3 + " Times");
        for (int i = 0; i < aResults.length; i++) {
            System.out.println((i + 1) + ": " + String.format("%04.3f", (((float) (aResults[i]) / N3) * 100)) + "% || "
                    + aResults[i] + " Times");
        }

        Dice diceB = new Dice(new int[] { 1, 2, 3, 3, 4, 5, 5, 5 });
        int[] bResults = new int[9];
        for (int i = 0; i < N3; i++) {
            bResults[diceA.roll() + diceB.roll() - 2]++;
        }

        System.out.println("\nTwo 8-Sided Dice Rolled " + N3 + " Times & Summed");
        for (int i = 0; i < bResults.length; i++) {
            System.out.println((i + 2) + ": " + (i + 2 < 10 ? " " : "") + (bResults[i] < N3 / 10 ? "0" : "")
                    + String.format("%04.3f", (((float) (bResults[i]) / N3) * 100)) + "% || " + bResults[i] + " Times");
        }
    }

    public static void problem4() {
        Dice[] theDice = new Dice[] {
                new Dice(new int[] { 1, 2, 3, 9, 10, 11 }),
                new Dice(new int[] { 0, 1, 7, 8, 8, 9 }),
                new Dice(new int[] { 5, 5, 6, 6, 7, 7 }),
                new Dice(new int[] { 3, 4, 4, 5, 11, 12 })
        };
        int[][] results = new int[4][4];
        for (int i = 0; i < N4; i++) {
            for (int j = 0; j < theDice.length; j++) {
                for (int q = j + 1; q < theDice.length; q++) {
                    int roll1 = theDice[j].roll();
                    int roll2 = theDice[q].roll();
                    int increment = 0;
                    if (roll1 > roll2) {
                        increment = 1;
                    } else if (roll2 > roll1) {
                        increment = -1;
                    }
                    results[j][q] += increment;
                    results[q][j] -= increment;
                    System.out.println("R" + j + ": " + roll1 + " R" + q + ": " + roll2 + "   Incrementing " + j + " "
                            + q + " by " + increment + "   Decrementing " + q + " " + j + " by " + increment);
                }
            }
        }

        System.out.println("     1:  2:  3:  4:");
        for (int i = 0; i < results.length; i++) {
            System.out.print((i + 1) + ":");
            for (int j = 0; j < results[i].length; j++) {
                System.out.print("   " + results[i][j]);
            }
            System.out.print('\n');
        }
    }
}