package leetcode.challenge.august;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> complexNumberProvider() {
        return Stream.of(
                Arguments.of("1+1i", "1+1i", "0+2i"),
                Arguments.of("1+-1i", "1+-1i", "0+-2i")
        );
    }

    @ParameterizedTest
    @MethodSource("complexNumberProvider")
    void givenComplexPair_whenComplexNumberMultiply_thenReturnExpected(String num1, String num2, String expected) {
        assertEquals(expected, solution.complexNumberMultiply(num1, num2));
    }

}