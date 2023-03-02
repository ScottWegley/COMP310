package Week7;

public class Mar3Script {

    public static double evalpoly(double[] coefs, double x){
        double result = 0;
        double xPower = Math.pow(x, coefs.length - 1);
        for (int i = coefs.length - 1; i >= 0; i--) {
            result += coefs[i] * xPower;
            xPower /= x;
        }
        return result;
    }

    public static void main(String[] args) {
        
    }

}