import java.util.Random;

public class Dice {

    private int sides;
    private boolean customSidesEnabled = false;
    private int[] customSides;
    private Random random;

    /**
     * Creates a new dice object with a specified number of sides.
     * @param _sides The number of sides the dice should have.
     */
    public Dice(int _sides) {
        if(_sides <= 0) {
            _sides = 6;
        }
        this.sides = _sides;
        random = new Random();
    }

    /**
     * Creates a dice with six sides numbered 1-6.
     */
    public Dice(){
        this(6);
    }

    /**
     * Creates a dice with custom faces supplied by the inputted array.
     * @param inSides An array full of custom dice faces.
     * The dice will have sides equal to the length of the array.
     */
    public Dice(int[] inSides){
        this(inSides.length);
        enableCustomSides(inSides);
    }

    /**
     * Enables the custom dice mode.  Requires an array of custom sides to roll from.
     * @param inSides An array full of each of the dice faces you'd like to put on the dice.  
     * Must be a length greater than or equal to the sides of the dice.  If it is greater,
     * excess faces will simply be ignored.
     * @return Returns false if the array submitted doesn't have enough members to fill the dice.
     */
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

    /**
     * Returns the dice to its original state, disabling custom sides mode and removing the array of custom sides.
     */
    public void disableCustomSides(){
        customSidesEnabled = false;
        customSides = null;
    }

    /**
     * @return Whether or not the Dice object is in custom sides mode.
     */
    public boolean hasCustomSides() {
        return customSidesEnabled;
    }

    /**
     * Rolls the dice and returns the result of the roll with each face being equally likely to pop up.
     * @return The result of the dice roll.  This defaults to a number from 1 to the number of sides.
     * If custom dice mode is enabled, it will return one of the custom dice faces.
     */
    public int roll() {
        int result = random.nextInt(this.sides) + 1;
        return (customSidesEnabled ? customSides[result - 1] : result);
    }
}
