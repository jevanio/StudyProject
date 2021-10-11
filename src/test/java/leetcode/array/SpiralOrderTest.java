package leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralOrderTest {

    private static Stream<Arguments> matrixProvided() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
                ),
                Arguments.of(
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}, Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("matrixProvided")
    void givenMatrix_whenSpiralOrder_thenReturnExpected(int[][] matrix, List<Integer> expected) {
        List<Integer> orderedList = new SpiralOrder().spiralOrder(matrix);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), orderedList.get(i));
        }
    }

}