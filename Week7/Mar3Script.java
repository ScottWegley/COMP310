package Week7;

public class Mar3Script {

    public static double evalpoly(double[] coefs, double x){
        double result = 0;
        double xPower = 1;
        double degree = coefs.length - 1;
        for (int i = 0; i <= degree; i++) {
            result+= coefs[i] * xPower;
            xPower *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        
    }

    public static double hornersMethod(double[] coeffs) {
        double result = coeffs[coeffs.length - 1];
        for (int i = coeffs.length - 2; i >= 0; i--) {
            result = result * x;
            result = result + coeffs[i];
        }
        return result;
    }
}