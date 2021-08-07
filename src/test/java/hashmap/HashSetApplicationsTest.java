package hashmap;

import leetcode.HashSetApplications;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HashSetApplicationsTest {

    @ParameterizedTest
    @MethodSource("singleNumberProvider")
    public void givenIntArray_whenSingleNumberLambda_thenReturnExpected(int[] nums, int expected) {
        assertEquals(expected, new HashSetApplications().singleNumberLambda(nums));

    }

    @ParameterizedTest
    @MethodSource("singleNumberProvider")
    public void givenIntArray_whenSingleNumberLambdaV2_thenReturnExpected(int[] nums, int expected) {
        assertEquals(expected, new HashSetApplications().singleNumberLambdaV2(nums));

    }

    @ParameterizedTest
    @MethodSource("singleNumberProvider")
    public void givenIntArray_whenSingleNumber_thenReturnExpected(int[] nums, int expected) {
        assertEquals(expected, new HashSetApplications().singleNumber(nums));

    }

    private static Stream<Arguments> singleNumberProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2),
                Arguments.of(new int[]{1, 2, 2}, 1),
                Arguments.of(new int[]{1, 1, 2, 2}, -1),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("intersectionProvided")
    public void givenIntArray_whenIntersection_thenReturnExpected(int[] nums1, int[] nums2, int[] expected) {
        int[] intersection = new HashSetApplications().intersection(nums1, nums2);
        Arrays.sort(intersection);
        Arrays.sort(expected);
        for (int i = 0; i < intersection.length; i++) {
            assertEquals(expected[i], intersection[i]);
            }
    }

    private static Stream<Arguments> intersectionProvided() {
        return Stream.of(
                Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{9, 4}),
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2})
        );
    }

    @ParameterizedTest
    @MethodSource("intersectionProvided")
    public void givenIntArray_whenIntersectionV2_thenReturnExpected(int[] nums1, int[] nums2, int[] expected) {
        int[] intersection = new HashSetApplications().intersectionV2(nums1, nums2);
        Arrays.sort(intersection);
        Arrays.sort(expected);
        for (int i = 0; i < intersection.length; i++) {
            assertEquals(expected[i], intersection[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("happyNumberProvided")
    public void givenNumber_whenIsHappy_thenReturnExpected(int number, boolean expected) {
        assertEquals(expected, new HashSetApplications().isHappy(number));
    }

    private static Stream<Arguments> happyNumberProvided() {
        return Stream.of(
                Arguments.of(19,true),
                Arguments.of(2,false)
        );
    }
}