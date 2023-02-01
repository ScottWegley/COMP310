public class Dice {

    private int sides;
    private boolean customSidesEnabled = false;
    private int[] customSides;

    public Dice(int _sides) {
        this.sides = _sides;
    }

    public void enableCustomSides() {
        customSidesEnabled = true;
    }

    public boolean enableCustomSides(int[] inSides) {
        if (inSides.length < this.sides) {
            return false;
        }
        enableCustomSides();
        customSides = new int[sides];
        for (int i = 0; i < customSides.length; i++) {
            customSides[i] = inSides[i];
        }
        return true;
    }
}
