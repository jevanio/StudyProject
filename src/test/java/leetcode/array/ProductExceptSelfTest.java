package leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductExceptSelfTest {

    public static Stream<Arguments> productProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}
                ),
                Arguments.of(
                        new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("productProvider")
    void givenArray_whenProductExceptSelf_thenReturnExpected(int[] nums, int[] expected) {
        int[] resultV1 = new ProductExceptSelf().productExceptSelfV1(nums);
        int[] resultV2 = new ProductExceptSelf().productExceptSelfV2(nums);
        for (int i = 0; i < nums.length; i++) {
            assertEquals(expected[i], resultV1[i]);
            assertEquals(expected[i], resultV2[i]);

        }
    }
}