package ru.stga.pdt.sandbox;

public class Primes {

  public static boolean prime(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i++) {

      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}
