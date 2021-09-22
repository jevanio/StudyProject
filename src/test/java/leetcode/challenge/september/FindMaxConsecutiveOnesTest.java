package leetcode.challenge.september;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMaxConsecutiveOnesTest {

    private final FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();

    private static Stream<Arguments> consecutiveOnesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1, 1, 1}, 3),
                Arguments.of(new int[]{1, 0, 1, 1, 0, 1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("consecutiveOnesProvider")
    void givenArrays_whenFindMaxConsecutiveOnes_thenReturnExpected(int[] nums, int maxCount) {
        assertEquals(maxCount, findMaxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }

}