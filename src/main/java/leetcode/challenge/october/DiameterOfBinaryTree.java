package leetcode.challenge.october;


import leetcode.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

import static leetcode.binarytree.TreeNodeUtils.height;

public class DiameterOfBinaryTree {


    int diameter = 0;

    /**
     * FirstApproach to get diameter of a binary tree.
     * This approach loop over each level of the tree and get the sum of the height between left and right child.
     * Then, if this sum is higher than a global max, then this is the new high.
     * This approach is not the fastest option since is getting the height multiple times.
     *
     * @param root root of a tree
     * @return max distance between two nodes on tree
     */
    public int diameterOfBinaryTreeV1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null || (root.left == null && root.right == null)) {
            return diameter;
        }
        queue.add(root);
        int path;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            path = height(node.left) + height(node.right);
            if (path > diameter) {
                diameter = path;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return diameter;
    }

    /**
     * This approach use a global param to get diameter of the tree when the height is obtain.
     *
     * @param root tree root
     * @return max distance between nodes of the tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return diameter;
        }
        diameter(root);

        return diameter;
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}
