
class Probabilities {

    public static int N2 = 1000000000;
    public static int N3 = 1000000000;
    public static int N4 = 10;

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

    public static void problem4(){

    }
}