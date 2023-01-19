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
            eNumber *= Math.pow(PrimeNumber.nextPrime(lastPrime), sequence[i]);
            lastPrime = currPrime;
        }
    }

    public long geteNumber() {
        return eNumber;
    }

    public long[] geteSourceSequence() {
        Stack<Long> sourceSequenceStack = new Stack<Long>();
        long[] primeFactorization = PrimeNumber.uniquePrimeFactors(eNumber);
        long startNum = eNumber;
        int i = primeFactorization.length - 1;
        while (startNum != 1) {
            if (startNum % primeFactorization[i] == 0) {
                startNum /= primeFactorization[i];
                sourceSequenceStack.push(primeFactorization[i]);
            } else {
                i -= 1;
            }
        }
        long[] sourceSequence = new long[sourceSequenceStack.size()];
        for (int q = 0; q < sourceSequence.length; q++) {
            sourceSequence[q] = sourceSequenceStack.pop();
        }
        return sourceSequence;
    }
}
