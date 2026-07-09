/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] index = {0};
        return buildTree(arr, index);
    }

    private TreeNode buildTree(String[] arr, int[] index) {
        if (arr[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[index[0]++]));
        node.left = buildTree(arr, index);
        node.right = buildTree(arr, index);

        return node;
    }
}