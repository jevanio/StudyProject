package leetcode.challenge.october;

import leetcode.binarytree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiameterOfBinaryTreeTest {

    private static Stream<Arguments> binaryTreeDiameterProvided() {
        TreeNode case1 = new TreeNode(1);
        case1.left = new TreeNode(2);
        case1.right = new TreeNode(3);
        case1.left.left = new TreeNode(4);
        case1.left.right = new TreeNode(5);

        TreeNode case2 = new TreeNode(1);
        case2.left = new TreeNode(2);
        case2.left.left = new TreeNode(3);
        case2.left.right = new TreeNode(4);
        case2.left.left.left = new TreeNode(5);
        case2.left.right.right = new TreeNode(6);

        TreeNode case3 = new TreeNode(1);
        case3.left = new TreeNode(2);

        TreeNode case4 = new TreeNode(1);

        TreeNode case5 = new TreeNode(1);
        case5.left = new TreeNode(2);
        case5.left.left = new TreeNode(3);
        case5.left.left.left = new TreeNode(4);
        case5.left.left.right = new TreeNode(5);
        case5.left.left.left.right = new TreeNode(6);
        case5.left.left.right.right = new TreeNode(7);

        TreeNode case6 = new TreeNode(1);
        case6.left = new TreeNode(2);
        case6.left.left = new TreeNode(3);
        case6.left.right = new TreeNode(4);
        case6.left.left.left = new TreeNode(5);
        case6.left.right.right = new TreeNode(6);
        case6.left.right.right.right = new TreeNode(7);


        return Stream.of(
                Arguments.of(case1, 3),
                Arguments.of(case2, 4),
                Arguments.of(case3, 1),
                Arguments.of(case4, 0),
                Arguments.of(case5, 4),
                Arguments.of(case6, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("binaryTreeDiameterProvided")
    void givenTree_whenDiameterOfBinaryTree_thenReturnExpected(TreeNode root, int expected) {
        assertEquals(expected, new DiameterOfBinaryTree().diameterOfBinaryTreeV1(root));
        assertEquals(expected, new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

}