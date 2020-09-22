package bentkowski.primefactors;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Primes {

    @Id
    public long id = 1L;

    @ElementCollection
    private Set<String> primeStrings = new HashSet<>();

    @Transient
    private Set<BigInteger> primeNumbers = new HashSet<>();

    public Set<BigInteger> getPrimeNumbers() {
        return primeNumbers;
    }

    public void setPrimeNumbers(Set<BigInteger> primeNumbers) {
        this.primeNumbers = primeNumbers;
    }

    public boolean addPrimeNumber(BigInteger prime) {
        return this.primeNumbers.add(prime);
    }

    public void addAllPrimes(List<BigInteger> primes) {
        this.primeNumbers.addAll(primes);
    }

    /**
     * patch to store Collection<BigInteger> as Collection<String>, cause it does not work with current db
     *  to store BigInt
     */
    public void save()  {
        this.primeStrings.clear();
        this.primeNumbers.forEach(number->primeStrings.add( number.toString()));
    }
    /**
     * patch to load Collection<BigInteger> from Collection<String>, cause it does not work with current db
     *  to store BigInt
     */
    public void load()  {
        this.primeNumbers.clear();
        this.primeStrings.forEach(string->primeNumbers.add(new BigInteger(string)));
    }
}
