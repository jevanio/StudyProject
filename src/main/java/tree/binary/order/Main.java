package tree.binary.order;

public class Main {
    public static void main(String[] args)
    {
        /* creating a binary tree and entering
         the nodes */
        BinaryTree tree_level = buildBinaryTree();

        tree_level.printLevelOrder();

        tree_level.printPreOrder();

        tree_level.printInOrder();

        tree_level.printPostOrder();
    }

    private static BinaryTree buildBinaryTree() {
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new TreeNode(1);
        tree_level.root.left = new TreeNode(2);
        tree_level.root.right = new TreeNode(3);
        tree_level.root.right.right = new TreeNode(6);
        tree_level.root.left.left = new TreeNode(4);
        tree_level.root.left.right = new TreeNode(5);
        return tree_level;
    }
}
