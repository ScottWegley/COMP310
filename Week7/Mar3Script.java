package Week7;

public class Mar3Script {

    public static double evalpoly(double[] coefs, double x){
        double result = 0;
        for (int i = coefs.length - 1; i >= 0; i--) {
            result += coefs[i] * Math.pow(x,i);
        }
        return result;
    }

    public static void main(String[] args) {
        
    }

}