package leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMedianSortedArraysTest {

    private final FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();

    private static Stream<Arguments> arraysProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.00000),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.50000),
                Arguments.of(new int[]{0, 0}, new int[]{0, 0}, 0.00000),
                Arguments.of(new int[]{}, new int[]{1}, 1.00000),
                Arguments.of(new int[]{2}, new int[]{}, 2.00000),
                Arguments.of(new int[]{}, new int[]{}, 0.00000),
                Arguments.of(new int[]{1, 3, 5, 7, 8, 9, 10}, new int[]{2, 4, 6}, 5.50000)
        );
    }

    @ParameterizedTest
    @MethodSource("arraysProvider")
    void givenArrays_whenFindMedianSortedArrays_thenReturnExpected(int[] nums1, int[] nums2, double expectedMedian) {
        assertEquals(expectedMedian, findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

}