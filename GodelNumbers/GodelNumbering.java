package GodelNumbers;

public class GodelNumbering {

    private long eNumber = 1;

    public GodelNumbering(int[] sequence){
        calculateE(sequence);
    }

    private void calculateE(int[] sequence){
        long lastPrime = 1;
        for(int i = 0; i < sequence.length; i++){
            long currPrime = PrimeNumber.nextPrime(lastPrime);
            eNumber *= Math.pow(PrimeNumber.nextPrime(lastPrime),sequence[i]);
            lastPrime = currPrime;
        }
    }

    public long geteNumber(){
        return eNumber;
    }
}
