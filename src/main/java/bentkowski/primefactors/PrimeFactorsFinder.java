package bentkowski.primefactors;



import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

public interface PrimeFactorsFinder {

    BigInteger ZERO = new BigInteger("0");
    BigInteger ONE = new BigInteger("1");
    BigInteger TWO = new BigInteger("2");


    public void findPrimeFactors(BigInteger N);

    public List<BigInteger> getFactors();
}
