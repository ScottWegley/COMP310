import java.util.Random;

public class Dice {

    private int sides;
    private boolean customSidesEnabled = false;
    private int[] customSides;
    private Random random;

    public Dice(int _sides) {
        this.sides = _sides;
        random = new Random();
    }

    public boolean enableCustomSides(int[] inSides) {
        if (inSides.length < this.sides) {
            return false;
        }
        customSidesEnabled = true;
        customSides = new int[sides];
        for (int i = 0; i < customSides.length; i++) {
            customSides[i] = inSides[i];
        }
        return true;
    }

    public void disableCustomSides(){
        customSidesEnabled = false;
        customSides = null;
    }

    public boolean hasCustomSides() {
        return customSidesEnabled;
    }

    public int roll() {
        int result = random.nextInt(this.sides) + 1;
        return (customSidesEnabled ? customSides[result - 1] : result);
    }
}
