package bentkowski.primefactors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PrimeFactorsHTMLController extends PrimeFactorsAbstractController {

    public PrimeFactorsHTMLController(PrimeFactorsService primeFactorService) {
        super(primeFactorService);
    }

    @GetMapping(value="/")
    public ModelAndView calculate(@RequestParam(required = false) String number) {

        ModelAndView modelAndView = new ModelAndView("primes");
        modelAndView.addObject("dto",calculateFactors(number));
        return modelAndView;
    }

}
