package tree.binary.order;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    public void printLevelOrder() {
        TreeNode current = root;
        System.out.println("\nLevel order traversal iterative of binary tree is - ");

        LevelOrderIterative(current);
    }

    private void LevelOrderIterative(TreeNode current) {
        queue.add(current);
        while (!queue.isEmpty()) {
            if (current.left != null) {
                current = current.left;
            } else {
                TreeNode pulledTreeNode = queue.poll();
                System.out.print(pulledTreeNode.data + " ");
                addLeafNodeToQueue(pulledTreeNode.left);
                addLeafNodeToQueue(pulledTreeNode.right);
            }
        }
    }

    private void addLeafNodeToQueue(TreeNode treeNode) {
        if (treeNode != null) {
            queue.add(treeNode);

        }
    }

    public void printPreOrder() {
        System.out.println("\nPre order recursive of binary tree is - ");

        preOrderRecursive(root);
    }

    private void preOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void printInOrder() {

        TreeNode current = root;

        System.out.println("\nInorder iterative of binary tree is - ");
        InOrderIterative(current);

        System.out.println("\nInorder recursive of binary tree is - ");
        InOrderRecursive(current);
    }

    private void InOrderIterative(TreeNode current) {
        while (current != null || stack.size() > 0) {

            /* Reach the left most Node of the
            current Node */
            while (current != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node'stack left subtree */
                stack.push(current);
                current = current.left;
            }

            /* Current must be NULL at this point */
            current = stack.pop();

            System.out.print(current.data + " ");

            /* we have visited the node and its
               left subtree.  Now, it'stack right
               subtree'stack turn */
            current = current.right;
        }
    }

    private void InOrderRecursive(TreeNode root) {
        if (root != null) {
            InOrderRecursive(root.left);
            System.out.print(root.data + " ");
            InOrderRecursive(root.right);
        }
    }

    public void printPostOrder() {
        System.out.println("\nPostorder recursive of binary tree is - ");
        PostOrderRecursive(root);
    }

    private void PostOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        } else {
            PostOrderRecursive(root.left);
            PostOrderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }
}