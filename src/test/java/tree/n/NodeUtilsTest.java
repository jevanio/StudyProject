package tree.n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tree.n.NodeUtils.nTreeLevelOrder;

class NodeUtilsTest {

    @ParameterizedTest
    @MethodSource("leveOrderParameterized")
    void givenTree_whenLevelOrder_thenReturnExpected(Node node, List<List<Integer>> expected) {
        List<List<Integer>> lists = nTreeLevelOrder(node);
        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < expected.get(i).size(); j++) {
                assertEquals(expected.get(i).get(j), lists.get(i).get(j));
            }
        }
    }

    private static Stream<Arguments> leveOrderParameterized() {
        Node node14 = new Node(14);
        Node node13 = new Node(13);
        Node node12 = new Node(12);
        Node node11 = new Node(11, Collections.singletonList(node14));
        Node node10 = new Node(10);
        Node node9 = new Node(9, Collections.singletonList(node13));
        Node node8 = new Node(8, Collections.singletonList(node12));
        Node node7 = new Node(7, Collections.singletonList(node11));
        Node node6 = new Node(6);
        Node node5 = new Node(5, Arrays.asList(node9, node10));
        Node node4 = new Node(4, Collections.singletonList(node8));
        Node node3 = new Node(3, Arrays.asList(node6, node7));
        Node node2 = new Node(2);
        Node node1 = new Node(1, Arrays.asList(node2, node3, node4, node5));

        List<List<Integer>> ordered1 = new ArrayList<>();
        ordered1.add(Collections.singletonList(1));
        ordered1.add(Arrays.asList(2, 3, 4, 5));
        ordered1.add(Arrays.asList(6, 7, 8, 9, 10));
        ordered1.add(Arrays.asList(11, 12, 13));
        ordered1.add(Collections.singletonList(14));

        Node scenario2Node6 = new Node(6);
        Node scenario2Node5 = new Node(5);
        Node scenario2Node4 = new Node(4);
        Node scenario2Node3 = new Node(3, Arrays.asList(scenario2Node5, scenario2Node6));
        Node scenario2Node2 = new Node(2);
        Node scenario2Node1 = new Node(1, Arrays.asList(scenario2Node3, scenario2Node2, scenario2Node4));
        List<List<Integer>> ordered2 = new ArrayList<>();
        ordered2.add(Collections.singletonList(1));
        ordered2.add(Arrays.asList(3, 2, 4));
        ordered2.add(Arrays.asList(5, 6));


        return Stream.of(
                Arguments.of(
                        node1, ordered1
                ),
                Arguments.of(scenario2Node1
                        , ordered2
                )
        );
    }
}