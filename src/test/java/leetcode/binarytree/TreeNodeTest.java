package leetcode.binarytree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeNodeTest {
    private static TreeNode root = new TreeNode(1);
    private static TreeNode rootUnbalanced = new TreeNode(1);

    @BeforeAll
    private static void beforeAll() {
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(10);

        rootUnbalanced.left = new TreeNode(2);
        rootUnbalanced.right = new TreeNode(3);
        rootUnbalanced.left.left = new TreeNode(4);
        rootUnbalanced.left.right = new TreeNode(5);
    }

    @Test
    public void givenTree_whenPreorderTraversal_thenReturnPreorderedValues() {

        List<Integer> preorderTraversal = new TreeNodeUtils().preorderTraversal(root);
        assertEquals(10, preorderTraversal.size());
        List<Integer> expected = Arrays.asList(1, 2, 4, 5, 8, 9, 3, 6, 10, 7);
        int idx = 0;
        for (Integer preorderedElement : preorderTraversal) {
            assertEquals(expected.get(idx++), preorderedElement);
        }
    }

    @Test
    public void givenTree_whenInorderTraversal_thenReturnInOrderedValues() {

        List<Integer> inorderTraversal = new TreeNodeUtils().inorderTraversal(root);
        assertEquals(10, inorderTraversal.size());
        List<Integer> expected = Arrays.asList(4, 2, 8, 5, 9, 1, 6, 10, 3, 7);
        int idx = 0;
        for (Integer preorderedElement : inorderTraversal) {
            assertEquals(expected.get(idx++), preorderedElement);
        }
    }

    @Test
    public void givenTree_whenInorderRecursive_thenReturnInOrderedValues() {

        List<Integer> inOrderRecursive = new TreeNodeUtils().inOrderRecursive(root);
        assertEquals(10, inOrderRecursive.size());
        List<Integer> expected = Arrays.asList(4, 2, 8, 5, 9, 1, 6, 10, 3, 7);
        int idx = 0;
        for (Integer preorderedElement : inOrderRecursive) {
            assertEquals(expected.get(idx++), preorderedElement);
        }
    }

    @Test
    public void givenTree_whenPostOrderTraversal_thenReturnPostOrderedValues() {

        List<Integer> postOrderTraversal = new TreeNodeUtils().postOrderTraversal(root);
        assertEquals(10, postOrderTraversal.size());
        List<Integer> expected = Arrays.asList(4, 8, 9, 5, 2, 10, 6, 7, 3, 1);
        int idx = 0;
        for (Integer postOrderedElement : postOrderTraversal) {
            assertEquals(expected.get(idx++), postOrderedElement);
        }
    }

    @ParameterizedTest
    @MethodSource("heightProvided")
    public void givenTree_whenHeight_thenReturn4(TreeNode root, int expected) {
        int height = new TreeNodeUtils().height(root);
        assertEquals(expected, height);
    }

    private static Stream<Arguments> heightProvided() {
        return Stream.of(
                Arguments.of(root, 4),
                Arguments.of(rootUnbalanced, 3)
        );

    }

    @Test
    public void givenTree_whenLevelOrderTraversal_thenReturnLevelOrderedValues() {

        List<List<Integer>> levelOrderTraversal = new TreeNodeUtils().levelOrder(root);
        assertEquals(4, levelOrderTraversal.size());
        List<List<Integer>> expected = Arrays.asList(Collections.singletonList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6, 7), Arrays.asList(8, 9, 10));
        int idx = 0;
        for (List<Integer> levelOrderedList : levelOrderTraversal) {
            for (int i = 0; i < levelOrderedList.size(); i++) {
                assertEquals(expected.get(idx).get(i), levelOrderedList.get(i));
            }
            idx++;
        }
    }

    @Test
    public void givenTree_whenLevelOrderTraversalV2_thenReturnLevelOrderedValues() {

        List<List<Integer>> levelOrderTraversal = new TreeNodeUtils().levelOrderV2(root);
        assertEquals(4, levelOrderTraversal.size());
        List<List<Integer>> expected = Arrays.asList(Collections.singletonList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6, 7), Arrays.asList(8, 9, 10));
        int idx = 0;
        for (List<Integer> levelOrderedList : levelOrderTraversal) {
            for (int i = 0; i < levelOrderedList.size(); i++) {
                assertEquals(expected.get(idx).get(i), levelOrderedList.get(i));
            }
            idx++;
        }
    }

    @Test
    public void givenTree_whenPostorderTraversalV2_thenReturnPostorderTree() {

        List<Integer> postOrderTraversal = new TreeNodeUtils().postorderTraversalV2(root);
        assertEquals(10, postOrderTraversal.size());
        List<Integer> expected = Arrays.asList(4, 8, 9, 5, 2, 10, 6, 7, 3, 1);
        int idx = 0;
        for (Integer postOrderedElement : postOrderTraversal) {
            assertEquals(expected.get(idx++), postOrderedElement);
        }
    }

    @ParameterizedTest
    @MethodSource("isSymmetricProvided")
    public void givenTree_whenIsSymmetric_thenReturnExpected(TreeNode treeNode, boolean expected) {
        assertEquals(expected,new TreeNodeUtils().isSymmetric(treeNode));

    }

    @ParameterizedTest
    @MethodSource("isSymmetricProvided")
    void givenTree_whenIsSymmetricRecursive_thenReturnExpected(TreeNode treeNode, boolean expected) {
        assertEquals(expected, new TreeNodeUtils().isSymmetricRecursive(treeNode));
    }

    private static Stream<Arguments> isSymmetricProvided() {
        TreeNode symmetricTree = new TreeNode(1);
        symmetricTree.left = new TreeNode(2);
        symmetricTree.right = new TreeNode(2);
        symmetricTree.left.right = new TreeNode(4);
        symmetricTree.right.left = new TreeNode(4);

        TreeNode noSymmetricTree = new TreeNode(1);
        noSymmetricTree.left = new TreeNode(2);
        noSymmetricTree.right = new TreeNode(2);
        noSymmetricTree.left.right = new TreeNode(4);
        noSymmetricTree.right.right = new TreeNode(4);

        TreeNode noSymmetricTree2 = new TreeNode(1);
        noSymmetricTree2.left = new TreeNode(2);
        noSymmetricTree2.right = new TreeNode(2);
        noSymmetricTree2.right.left = new TreeNode(4);
        noSymmetricTree2.right.right = new TreeNode(4);



        return Stream.of(
                Arguments.of(symmetricTree, true),
                Arguments.of(noSymmetricTree, false),
                Arguments.of(noSymmetricTree2, false)
        );
    }

    @Test
    public void givenTree_whenHasPathSum_thenReturnExpected() {
        assertTrue(new TreeNodeUtils().hasPathSum(root, 7));
    }
}