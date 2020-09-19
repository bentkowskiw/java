package bentkowski.primefactors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

public abstract class PrimeFactorsAbstractController {

    @Autowired
    protected PollardRhoPrimeFactorsService primeFactorService;

    public PrimeFactorsAbstractController() {
    }


    public PrimeFactorsResult calculateFactors(@RequestParam(required = false) String number) {

        System.out.println("Number param: " + number);
        if (null == number || number.isBlank())
            number = "1234567890";

        BigInteger N = new BigInteger(number);

        return primeFactorService.findPrimeFactors(N);
        //PrimeFactorsResult factors = new PrimeFactorsResult(new int[]{2,3,5});
        //return factors;
    }
}