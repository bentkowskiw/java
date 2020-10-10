package io.bentkowski.primefactors;



import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

public interface PrimeFactorsFinder {



    public final static BigInteger ZERO = BigInteger.valueOf(0l);
    public final static BigInteger ONE = BigInteger.valueOf(1l);
    public final static BigInteger TWO = BigInteger.valueOf(2l);
    public final static BigInteger THREE = BigInteger.valueOf(3l);
    public final static BigInteger TEN = BigInteger.valueOf(10l);
    public final static BigInteger TENTHOUSAND = BigInteger.valueOf(10_000l);

    default  void init()  {

    }

    public void findPrimeFactors(BigInteger N) ;

    public List<BigInteger> getFactors();
}
