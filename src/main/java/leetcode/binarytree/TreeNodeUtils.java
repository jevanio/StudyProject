package leetcode.binarytree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TreeNodeUtils {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        if (root == null) {
            return preorderList;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            preorderList.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return preorderList;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        if (root == null) {
            return inorderList;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode actual = root;
        while (actual != null || !stack.isEmpty()) {
            while (actual != null) {
                stack.push(actual);
                actual = actual.left;
            }
            actual = stack.pop();
            inorderList.add(actual.val);
            actual = actual.right;
        }

        return inorderList;
    }


    public List<Integer> inOrderRecursive(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        return inOrderRecursive(root, inOrder);
    }

    public List<Integer> inOrderRecursive(TreeNode node, List<Integer> inOrder) {
        if (node.left != null) {
            inOrderRecursive(node.left, inOrder);
        }
        inOrder.add(node.val);
        if (node.right != null) {
            inOrderRecursive(node.right, inOrder);
        }
        return inOrder;

    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> postOrderTraversal = new ArrayList<>();
        if (root == null) {
            return postOrderTraversal;
        }


        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            postOrderTraversal.add(0, curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return postOrderTraversal;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int totalHeight = height(root);

        List<Queue<TreeNode>> queueList = new ArrayList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        for (int i = 0; i < totalHeight; i++) {
            queueList.add(new LinkedList<>());
            levelOrder.add(new ArrayList<>());
        }

        Queue<TreeNode> queue1 = queueList.get(0);
        queue1.add(root);
        for (int i = 0; i < totalHeight; i++) {
            Queue<TreeNode> actualQueue = queueList.get(i);
            while (!actualQueue.isEmpty()) {
                TreeNode poll = actualQueue.poll();
                if (i + 1 != totalHeight) {
                    Queue<TreeNode> nextQueue = queueList.get(i + 1);
                    if (poll.left != null) {
                        nextQueue.add(poll.left);
                    }
                    if (poll.right != null) {
                        nextQueue.add(poll.right);
                    }
                }
                List<Integer> level = levelOrder.get(i);
                level.add(poll.val);
            }
        }

        return levelOrder;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left) + 1, height(root.right) + 1);
        }
    }

    public List<List<Integer>> levelOrderV2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queueList = new LinkedList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();

        queueList.add(root);
        while (!queueList.isEmpty()) {
            int queueSize = queueList.size();
            List<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queueList.poll();
                if (poll != null) {
                    levelValues.add(poll.val);
                    if (poll.left != null) {
                        queueList.add(poll.left);
                    }
                    if (poll.right != null) {
                        queueList.add(poll.right);
                    }
                }
            }
            levelOrder.add(levelValues);
        }

        return levelOrder;
    }

    public List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return postorder;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            postorder.add(0, pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        return postorder;
    }

    public boolean isSymmetric(TreeNode root) {
        boolean isSymmetric = true;
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (isSymmetric && !isNullQueue(queue)) {
            List<Integer> levelList = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    levelList.add(null);
                    queue.add(null);
                } else {
                    levelList.add(poll.val);
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
            isSymmetric = isSymmetric(levelList);
        }
        return isSymmetric;
    }

    private boolean isNullQueue(Queue<TreeNode> queue) {
        for (TreeNode q : queue)
            if (q != null) {
                return false;
            }
        return true;
    }

    private boolean isSymmetric(List<Integer> levelList) {
        if (levelList.size() % 2 == 1) {
            return false;
        } else {
            for (int i = 0; i < levelList.size() / 2; i++) {
                if (levelList.get(i) != levelList.get(levelList.size() - i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        return isSymmetricRecursive(root, root);
    }

    private boolean isSymmetricRecursive(TreeNode treeNodeLeft, TreeNode treeNodeRight) {
        if (treeNodeLeft == null && treeNodeRight == null) {
            return true;
        } else if (treeNodeLeft == null || treeNodeRight == null) {
            return false;
        } else {
            return (treeNodeLeft.val == treeNodeRight.val) && isSymmetricRecursive(treeNodeLeft.left, treeNodeRight.right)
                    && isSymmetricRecursive(treeNodeLeft.right, treeNodeRight.left);
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        sumPath(root, set, 0);
        return set.contains(targetSum);

    }

    private void sumPath(TreeNode root, Set<Integer> set, int sum) {
        if (root.left==null && root.right == null) {
            set.add(sum + root.val);
        } else {
            sum += root.val;
            if (root.left != null) {
                sumPath(root.left, set, sum);
            }
            if (root.right!= null) {
                sumPath(root.right, set, sum);
            }
        }
    }
}
