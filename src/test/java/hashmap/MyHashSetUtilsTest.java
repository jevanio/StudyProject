package hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetUtilsTest {

    @ParameterizedTest
    @MethodSource("containsDuplicateProvider")
    public void givenNums_whenContainsDuplicate_thenReturnExpected(int[] nums, boolean expected) {
        MyHashSetUtils myHashSetUtils = new MyHashSetUtils();
        assertEquals(expected, myHashSetUtils.containsDuplicate(nums));
    }

    private static Stream<Arguments> containsDuplicateProvider() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 2}, true),
                Arguments.of((Object) new int[]{1, 81, 2}, false),
                Arguments.of(null, false),
                Arguments.of((Object) new int[]{}, false),
                Arguments.of((Object) new int[]{2142}, false),
                Arguments.of((Object) new int[]{1, 5, -2, -4, 0}, false),
                Arguments.of((Object) new int[]{1, 5, -2, -4, -4}, true),
                Arguments.of((Object) new int[]{1, 5, -2, -4, 4}, false)
        );
    }

}