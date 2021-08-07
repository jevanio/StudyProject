package hackerrank.biginteger;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static hackerrank.biginteger.JavaPrimality.isPrime;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaPrimalityTest {

    @ParameterizedTest
    @ValueSource(strings = {"7", "13"})
    void givenPrime_whenIsPrime_thenReturnPrime(String n) {
        assertEquals("prime", isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "6"})
    void givenPrime_whenIsPrime_thenReturnNotPrime(String n) {
        assertEquals("not prime", isPrime(n));
    }
}