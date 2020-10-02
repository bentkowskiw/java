package bentkowski.primefactors;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;

public class PollardRhoPrimeFactorsFinder implements PrimeFactorsFinder {
    private  java.util.List<BigInteger> factors;
    SecureRandom random = new SecureRandom();




    public PollardRhoPrimeFactorsFinder() {
        this.factors = new ArrayList<>();
    }


    public List<BigInteger> getFactors() {
        return factors;
    }


    void factor(BigInteger N) {

        if (N.compareTo(PrimeFactorsFinder.ONE) == 0) return;
        if (N.isProbablePrime(20)) {
            factors.add(N);
            return;
        }
        BigInteger divisor = rho(N);
        factor(divisor);
        factor(N.divide(divisor));
    }

    @Override
    public void findPrimeFactors(BigInteger N) {
        factor(N);
    }


    private BigInteger rho(BigInteger N) {
        BigInteger divisor;
        BigInteger c = new BigInteger(N.bitLength(),random);
        BigInteger x = new BigInteger(N.bitLength(),random);
        BigInteger xx = x;

        // check divisibility by 2
        if (N.mod(PrimeFactorsFinder.TWO).compareTo(PrimeFactorsFinder.ZERO) == 0) return PrimeFactorsFinder.TWO;

        do {
            x = x.multiply(x).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            divisor = x.subtract(xx).gcd(N);
        } while ((divisor.compareTo(PrimeFactorsFinder.ONE)) == 0);

        return divisor;
    }
}
