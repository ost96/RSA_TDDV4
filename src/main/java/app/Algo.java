package app;

import java.lang.Math;
import java.math.BigInteger;
import java.util.function.BiFunction;

public class Algo {
    // returns true if a and b are coprime and false otherwise
    public static boolean euclidesAreCoprime(BigInteger a, BigInteger b) throws IllegalArgumentException {
        if (a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO))
            throw new IllegalArgumentException("arguments cannot be equal to 0");
        else if (euclidesGCD(a, b).compareTo(BigInteger.ONE) == 0)
            return true;
        else
            return false;
    }

    public static BigInteger euclidesInverse(BigInteger a, BigInteger m) throws IllegalArgumentException {

            return new BigInteger("0");


    }

    // returns the GCD of a and b
    // returns the GCD of a and b
    public static BigInteger euclidesGCD(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

}
