package hackerrank.biginteger;

import java.math.BigInteger;

public class JavaPrimality {

    private JavaPrimality() {

    }

    public static String isPrime(String n) {
        BigInteger bigInteger = new BigInteger(n);
        if (bigInteger.isProbablePrime(1)) {
            return "prime";
        } else {
            return "not prime";
        }

    }

}
