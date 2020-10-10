package io.bentkowski.primefactors;


import io.bentkowski.primefactors.PrimeFactorsFinder;
import io.bentkowski.primefactors.PrimeFactorsService;
import org.junit.Assert;

import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.security.SecureRandom;

import java.util.List;
import java.util.Random;

class PrimeFactorsServiceTest {

    private BigInteger big;
    private int bitLength;
    private PrimeFactorsService service;
    private Random rand;

    private PrimeFactorsFinder result;



    @BeforeEach
    void setUp() {
        bitLength = 128;
    }

    @AfterEach
    void tearDown() {
        /*


         */
    }

    @Test
    @Timeout(20L)
    @DisplayName("123")
    void findPrimeFactors() {
        bitLength = 128
        ;
        service = new PrimeFactorsService();
        Random rand = new SecureRandom();
        BigInteger big;
        big = new BigInteger(bitLength,rand);
        result = service.findPrimeFactors(big);
        List<BigInteger> factors = result.getFactors();

        BigInteger out = new BigInteger("1");
        for(BigInteger bigInteger: factors) {
            out = out.multiply(bigInteger);
        }
        Assert.assertEquals(out,big);
    }
}