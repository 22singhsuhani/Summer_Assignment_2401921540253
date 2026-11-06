import java.util.*;

class Solution {
    // Maps original node -> cloned node
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If the node is already cloned, return the cloned instance
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create a new clone of the current node (without neighbors yet)
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Recursively clone and add all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
