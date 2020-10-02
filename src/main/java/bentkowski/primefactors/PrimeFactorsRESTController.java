package bentkowski.primefactors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeFactorsRESTController extends PrimeFactorsAbstractController  {
    public PrimeFactorsRESTController(PrimeFactorsService primeFactorService) {
        super(primeFactorService);
    }

    @Override
    @GetMapping(value="/REST")
    public PrimeFactorsFinder calculateFactors(String number) {
        return super.calculateFactors(number);
    }
}
