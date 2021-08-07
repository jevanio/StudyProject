package tree.n;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NodeUtils {

    private NodeUtils() {
    }

    // Create an empty List for each level
    // For each node on level, get one out of the pool and add it to the list
    // when all children has been saved, add list to orderList
    public static List<List<Integer>> nTreeLevelOrder(Node root) {
        List<List<Integer>> orderedList = new ArrayList<>();
        if (root == null) {
            return orderedList;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int numChildren = queue.size();
            for (int i = 0; i < numChildren; i++) {
                Node poll = queue.poll();
                if (poll != null) {
                    list.add(poll.val);
                    if (poll.children != null) {
                        queue.addAll(poll.children);
                    }
                }
            }
            orderedList.add(list);
        }
        return orderedList;
    }
}
