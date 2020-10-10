package io.bentkowski.cucumber;

import io.bentkowski.primefactors.PrimeFactorsFinder;
import io.bentkowski.primefactors.PrimeFactorsService;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PrimeFactorsCucumberTest {

    private BigInteger bigInteger;
    private PrimeFactorsService service;
    private PrimeFactorsFinder resultDTO;

    @Given("^Random generated <Number>$")
    public void randomGeneratedNumber() {
        service = new PrimeFactorsService();
        SecureRandom secureRandom = new SecureRandom();
        bigInteger =  new BigInteger(264,20,secureRandom);
    }

    @When("^The number is split into <prime factors>$")
    public void theNumberIsSplitIntoPrimeFactors() {
        resultDTO = service.findPrimeFactors(bigInteger);
    }

    @Then("^The <prime factors> multiplied must equal <Number>$")
    public void thePrimeFactorsMultipliedMustEqualNumber() {
        BigInteger check = new BigInteger("1");
        for(BigInteger factor: resultDTO.getFactors())   {
            check = check.multiply(factor);
        }
        System.out.println(resultDTO.getFactors());
        System.out.print(check);
        System.out.print(" = ");
        System.out.println(bigInteger);
        Assert.assertEquals(check,bigInteger);
    }
}
