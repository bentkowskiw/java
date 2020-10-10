package io.bentkowski.primefactors;

import java.math.BigInteger;
import java.util.List;

public class BrentsFactorsFinder implements PrimeFactorsFinder  {


    @Override
    public List<BigInteger> getFactors() {
        return factors;
    }

    public void setFactors(List<BigInteger> factors) {
        this.factors = factors;
    }

    private List<BigInteger> factors;

public void findPrimeFactors(BigInteger N){



}

private BigInteger factorizebrent(BigInteger n) {
    BigInteger k = new BigInteger("1");
    BigInteger r = new BigInteger("1");
    BigInteger i = new BigInteger("1");
    BigInteger m = new BigInteger("1");
    BigInteger iter = new BigInteger("1");
    BigInteger z = new BigInteger("1");
    BigInteger x = new BigInteger("1");
    BigInteger y = new BigInteger("1");
    BigInteger q = new BigInteger("1");
    BigInteger ys = new BigInteger("1");

    m=TEN;
    r=ONE;
    iter=ZERO;
    z=ZERO;
    y=z;
    q=ONE;

    do {
        x=y;
        for (i=ONE;i.compareTo(r)<=0;i=i.add(ONE)) y=((y.multiply(y)).add(THREE)).mod(n);
        k=ZERO;
        do {
            iter=iter.add(ONE);
// System.out.print("iter=" + iter.toString() + '\r');
            ys=y;
            for (i=ONE;i.compareTo(mr_min(m,r.subtract(k)))<=0;i=i.add(ONE)) {
                y=((y.multiply(y)).add(THREE)).mod(n);
                q=((y.subtract(x)).multiply(q)).mod(n);
            }
            z=n.gcd(q);
            k=k.add(m);
        } while (k.compareTo(r)<0 && z.compareTo(ONE)==0);
        r=r.multiply(TWO);
    } while (z.compareTo(ONE)==0 && iter.compareTo(TENTHOUSAND)<0);

    if (z.compareTo(n)==0) do {
        ys=((ys.multiply(ys)).add(THREE)).mod(n);
        z=n.gcd(ys.subtract(x));
    } while (z.compareTo(ONE)==0);

    return z;
}

private BigInteger mr_min(BigInteger a, BigInteger b)   {
return BigInteger.ONE;
}

}
