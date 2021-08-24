package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamsTest {

    @Test
    void testReduceExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer total = numbers.stream().reduce(0, (subTotal, element) -> subTotal + element);
        assertEquals(21, total);
    }
}
