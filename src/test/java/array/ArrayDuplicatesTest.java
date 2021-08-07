package array;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayDuplicatesTest {

    private static ArrayDuplicates arrayDuplicates;

    @BeforeAll
    public static void setUp() {
        arrayDuplicates = new ArrayDuplicates();
    }

    @ParameterizedTest
    @MethodSource("integerArrayProvider")
    public void givenBasicScenario_whenRemoveDuplicates_returnExpectedK(int[] nums, int[] expectedNums) {
        int k = arrayDuplicates.removeDuplicates(nums);
        System.out.println(k);

        assertEquals(expectedNums.length, k);

        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }

    }

    private static Stream<Arguments> removeDuplicatesProvider() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 2}, new int[]{1, 2}),
                Arguments.of((Object) new int[]{}, new int[]{}),
                Arguments.of((Object) new int[]{1, 1, 1}, new int[]{1}),
                Arguments.of((Object) new int[]{1, 2, 2}, new int[]{1, 2}),
                Arguments.of((Object) new int[]{1, 2, 2, 3}, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("removeValueProvider")
    public void givenBasicScenario_whenRemoveValue_returnExpectedK(int[] nums, int value, int[] expectedNums) {
        int k = arrayDuplicates.removeValue(nums,value);
        System.out.println(k);

        assertEquals(expectedNums.length, k);

        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("removeValueProvider")
    public void givenBasicScenario_whenSimpleRemoveValue_returnExpectedK(int[] nums, int value, int[] expectedNums) {
        int k = arrayDuplicates.simpleRemoveElement(nums,value);
        System.out.println(k);

        assertEquals(expectedNums.length, k);

        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }


    private static Stream<Arguments> removeValueProvider() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 2}, 1, new int[]{2}),
                Arguments.of((Object) new int[]{}, 1, new int[]{}),
                Arguments.of((Object) new int[]{1, 1, 1}, 1, new int[]{}),
                Arguments.of((Object) new int[]{1, 2, 2}, 1, new int[]{2, 2}),
                Arguments.of((Object) new int[]{1, 2, 2, 3}, 2, new int[]{1, 3}),
                Arguments.of((Object) new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 4, 0, 3})
        );
    }

}