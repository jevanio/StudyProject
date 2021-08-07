package word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringProblemsTest {

    private final StringProblems stringProblems = new StringProblems();

    private static Stream<Arguments> strStrProvider() {
        return Stream.of(
                Arguments.of("hello","ll", 2),
                Arguments.of("","", 0),
                Arguments.of("atata","eta", -1),
                Arguments.of("eta","eta", 0),
                Arguments.of("eta","etata", -1),
                Arguments.of("","a", -1),
                Arguments.of("abc","c", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("strStrProvider")
    public void givenTestCases_whenStrStr_thenPosition(String haystack, String needle, int pos) {
        assertEquals(pos,stringProblems.strStr(haystack,needle));
    }

}