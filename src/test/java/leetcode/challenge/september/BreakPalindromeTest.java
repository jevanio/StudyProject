package leetcode.challenge.september;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BreakPalindromeTest {

    private final BreakPalindrome breakPalindrome = new BreakPalindrome();

    private static Stream<Arguments> palindromeProvider() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("a", ""),
                Arguments.of("b", ""),
                Arguments.of("aaa", "aab"),
                Arguments.of("abccba", "aaccba"),
                Arguments.of("aa", "ab"),
                Arguments.of(null, ""),
                Arguments.of("aba", "abb")
        );
    }

    @ParameterizedTest
    @MethodSource("palindromeProvider")
    void givenPalindrome_whenBreakPalindrome_thenReturnExpected(String palindrome, String brokenPalindrome) {
        assertEquals(brokenPalindrome, breakPalindrome.breakPalindrome(palindrome));
        assertEquals(brokenPalindrome, breakPalindrome.breakPalindromeV2(palindrome));
    }
}