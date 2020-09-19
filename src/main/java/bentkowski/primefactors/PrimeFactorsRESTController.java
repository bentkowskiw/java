package bentkowski.primefactors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeFactorsRESTController extends PrimeFactorsAbstractController  {

    @Override
    @GetMapping(value="/REST")
    public PrimeFactorsResult calculateFactors(String number) {
        return super.calculateFactors(number);
    }
}
