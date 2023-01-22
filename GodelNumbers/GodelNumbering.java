package GodelNumbers;

public class GodelNumbering {

    private long eNumber = 1;

    public GodelNumbering(int... sequence) {
        if (sequence.length == 0) {
            sequence = new int[] { 1, 2, 3 };
        }
        calculateE(sequence);
    }

    private void calculateE(int[] sequence) {
        long lastPrime = 1;
        for (int i = 0; i < sequence.length; i++) {
            long currPrime = PrimeNumber.nextPrime(lastPrime);
            eNumber *= (long)Math.pow(currPrime, sequence[i]);
            lastPrime = currPrime;
        }
    }

    public long geteNumber() {
        return eNumber;
    }

    public long[] geteSourceSequence() {
        long[] primeFactorization = PrimeNumber.uniquePrimeFactors(eNumber);
        long[] sourceSequence = new long[primeFactorization.length];
        long startNum = eNumber;
        int i = primeFactorization.length - 1;

        for (int q = 0; q <= i; q++) {
            sourceSequence[q] = 1;
        }

        long previousFactor = 0;
        while (startNum != 1) {
            if (startNum % primeFactorization[i] == 0) {
                if(previousFactor == primeFactorization[i]){
                    sourceSequence[i] += 1;
                }
                previousFactor = primeFactorization[i];
                startNum /= primeFactorization[i];
            } else {
                i -= 1;
            }
        }
        return sourceSequence;
    }
}
