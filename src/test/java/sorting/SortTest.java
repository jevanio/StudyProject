package sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sorting.Sort.bubbleSort;
import static sorting.Sort.insertionSort;
import static sorting.Sort.mergeSort;
import static sorting.Sort.selectionSort;

class SortTest {

    @ParameterizedTest
    @MethodSource("sortProvider")
    void givenArray_whenSelectionSort_thenExpected(int[] array, int[] expected) {
        selectionSort(array);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], array[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("sortProvider")
    void givenArray_whenBubbleSort_thenExpected(int[] array, int[] expected) {
        bubbleSort(array);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], array[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("sortProvider")
    void givenArray_whenInsertionSort_thenExpected(int[] array, int[] expected) {
        insertionSort(array);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], array[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("sortProvider")
    void givenArray_whenMergeSort_thenExpected(int[] array, int[] expected) {
        mergeSort(array);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], array[i]);
        }
    }

    private static Stream<Arguments> sortProvider() {
        return Stream.of(
                Arguments.of(new int[]{64, 25, 12, 22, 11}, new int[]{11, 12, 22, 25, 64}),
                Arguments.of(new int[]{4, 3, 2, 10, 12, 1, 5, 6}, new int[]{1, 2, 3, 4, 5, 6, 10, 12}),
                Arguments.of(new int[]{38, 27, 43, 3, 9, 82, 10}, new int[]{3, 9, 10, 27, 38, 43, 82})
        );
    }
}