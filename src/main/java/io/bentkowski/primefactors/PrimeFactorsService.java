package io.bentkowski.primefactors;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;


@Service
public class PrimeFactorsService {


    @PersistenceContext
    private EntityManager entityManager;
    private Primes primes;

    public PrimeFactorsService() {


        //primes = load();
        primes = new Primes();
        System.out.println("Constructor");

    }

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init() {
        System.out.println("App ready");

    }


    @Transactional
    public PrimeFactorsFinder findPrimeFactors(BigInteger N) {

        PrimeFactorsFinder finder = new PollardRhoPrimeFactorsFinder();

        finder.findPrimeFactors(N);
        primes.addAllPrimes(finder.getFactors());
        save(primes);
        return finder;
    }


    private void save(Primes primes)    {
        primes.save();
        //entityManager.persist(primes);
    }


    private Primes load()   {
        Primes primes = entityManager.find(Primes.class, 1L);
        if (null==primes)
            return new Primes();
        primes.load();
        return primes;
    }

}
