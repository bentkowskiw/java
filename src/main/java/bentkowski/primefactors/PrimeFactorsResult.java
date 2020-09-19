package bentkowski.primefactors;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;


public class PrimeFactorsResult {
    private  java.util.List<BigInteger> factors;



    public void setPrimes(Set<BigInteger> primes) {
        this.primes = primes;
    }

    private Set<BigInteger> primes;


    public PrimeFactorsResult() {
        this.factors = new ArrayList<>();
    }


    public List<BigInteger> getFactors() {
        return factors;
    }

    public BigInteger getOutcome() {
        BigInteger outcome = BigInteger.valueOf(1L);
        for (BigInteger factor : this.factors) {
           outcome = outcome.multiply(factor);
        }
        return outcome;
    }



    public void addFactor(BigInteger factor) {
        this.factors.add(factor);
    }
}
