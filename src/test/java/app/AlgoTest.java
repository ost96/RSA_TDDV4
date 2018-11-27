package app;

import app.Algo;
import java.lang.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class AlgoTest {
    @Test
    public void euclidesAreCoprimeTest_primes() {
        // prime
        BigInteger a = new BigInteger("10000019");
        // prime
        BigInteger b = new BigInteger("10002347");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertTrue(result);
    }

    @Test
    public void euclidesAreCoprimeTest_pseudoprimeCoprimes() {
        // pseudoprime (3 * 43 * 257)
        BigInteger a = new BigInteger("33153");
        // pseudoprime (151 * 331)
        BigInteger b = new BigInteger("49981");
        boolean result = Algo.euclidesAreCoprime(a, b);
        assertTrue(result);
    }

    @Test
    public void euclidesAreCoprimeTest_notCoprimes() {
        // (3 * k)
        BigInteger a = new BigInteger("100");
        // pseudoprime (3 * 43 * 257)
        BigInteger b = new BigInteger("50");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertFalse(result);
    }

    @Test
    public void euclidesAreCoprimeTest_primesWithNegative() {
        // negative prime
        BigInteger a = new BigInteger("-10000019");
        // prime
        BigInteger b = new BigInteger("10002347");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertTrue(result);
    }

    @Test
    public void euclidesAreCoprimeTest_pseudoprimeCoprimesWithNegative() {
        // negative pseudoprime (3 * 43 * 257)
        BigInteger a = new BigInteger("-33153");
        // pseudoprime (151 * 331)
        BigInteger b = new BigInteger("49981");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertTrue(result);
    }

    @Test
    public void euclidesAreCoprimeTest_notCoprimesWithNegative() {
        // negative number (3 * k)
        BigInteger a = new BigInteger("-10000021");
        // pseudoprime (3 * 43 * 257)
        BigInteger b = new BigInteger("33153");
        boolean result = Algo.euclidesAreCoprime(a, b);

        assertTrue(result);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void euclidesAreCoprimeTest_withZero() {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = new BigInteger("4");

        exception.expect(IllegalArgumentException.class);
        Algo.euclidesAreCoprime(a, b);
    }


    @Test
    public void euclidesInverseTest_barelyLegalArguments() {
        BigInteger a = BigInteger.ZERO;
        BigInteger m = BigInteger.ONE;

        Algo.euclidesInverse(a, m);
        // no exception thrown = success
    }

    @Test
    public void euclidesInverseTest_illegalFirstArgument() {
        BigInteger a = new BigInteger("-1");
        BigInteger m = new BigInteger("678");

        exception.expect(IllegalArgumentException.class);
        Algo.euclidesInverse(a, m);
    }

    @Test
    public void euclidesInverseTest_illegalSecondArgument() {
        BigInteger a = new BigInteger("10000");
        BigInteger m = new BigInteger("0");

        exception.expect(IllegalArgumentException.class);
        Algo.euclidesInverse(a, m);
    }


    @Test
    public void euclidesGCD_knownResult () {
        BigInteger a = new BigInteger("12");
        BigInteger b = new BigInteger("3");

        BigInteger result = Algo.euclidesGCD(a, b);
        assertEquals(new BigInteger("3"), result);
    }
}
