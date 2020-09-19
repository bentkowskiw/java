package bentkowski.primefactors;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.security.SecureRandom;


@Service
public class PollardRhoPrimeFactorsService {
    private final static BigInteger ZERO = new BigInteger("0");
    private final static BigInteger ONE = new BigInteger("1");
    private final static BigInteger TWO = new BigInteger("2");
    private final static SecureRandom random = new SecureRandom();


    @PersistenceContext
    private EntityManager entityManager;

    public PollardRhoPrimeFactorsService() {

        System.out.println("Constructor");

    }

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init() {
        System.out.println("App ready");

    }

    private BigInteger rho(BigInteger N) {
        BigInteger divisor;
        BigInteger c = new BigInteger(N.bitLength(), random);
        BigInteger x = new BigInteger(N.bitLength(), random);
        BigInteger xx = x;

        // check divisibility by 2
        if (N.mod(TWO).compareTo(ZERO) == 0) return TWO;

        do {
            x = x.multiply(x).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            divisor = x.subtract(xx).gcd(N);
        } while ((divisor.compareTo(ONE)) == 0);

        return divisor;
    }

    @Transactional
    public PrimeFactorsResult findPrimeFactors(BigInteger N) {

        PrimeFactorsResult result = new PrimeFactorsResult();

        Primes primes;
        primes = load();


        for(BigInteger prime: primes.getPrimeNumbers())  {
            if (N.mod(prime).compareTo(ZERO) == 0) {
                result.addFactor(prime);
                N = N.divide(prime);
            }
        }

        factor(N, result);
        primes.addAllPrimes(result.getFactors());
        save(primes);
        result.setPrimes(primes.getPrimeNumbers());
        return result;
    }

    private void save(Primes primes)    {
        primes.save();
        entityManager.persist(primes);
    }

    private Primes load()   {
        Primes primes = entityManager.find(Primes.class, 1L);
        if (null==primes)
            return new Primes();
        primes.load();
        return primes;
    }

    private void factor(BigInteger N, PrimeFactorsResult result) {


        if (N.compareTo(ONE) == 0) return;
        if (N.isProbablePrime(20)) {
            result.addFactor(N);
            return ;
        }
        BigInteger divisor = rho(N);
        factor(divisor, result);
        factor(N.divide(divisor), result);
        return;
    }
}
