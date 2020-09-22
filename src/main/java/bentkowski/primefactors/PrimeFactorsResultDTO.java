package bentkowski.primefactors;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;

/**
 * Data Transfer Object for PrimeFactors of a given Number
 */
public class PrimeFactorsResultDTO {
    private  java.util.List<BigInteger> factors;



    public void setPrimes(Set<BigInteger> primes) {
        this.primes = primes;
    }

    private Set<BigInteger> primes;


    public PrimeFactorsResultDTO() {
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
