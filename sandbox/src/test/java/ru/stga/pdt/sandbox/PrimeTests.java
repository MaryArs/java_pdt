package ru.stga.pdt.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrimes(){
    Assert.assertTrue(Primes.prime(Integer.MAX_VALUE));
  }

}
