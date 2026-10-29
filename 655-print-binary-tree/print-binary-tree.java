class Solution {
public List<List<String>> printTree(TreeNode root) {
int height = height(root);
int m = height;
int n = (int) Math.pow(2, height) - 1;


    List<List<String>> ans = new ArrayList<>();

    for (int i = 0; i < m; i++) {
        List<String> row = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            row.add("");
        }
        ans.add(row);
    }

    fill(root, ans, 0, 0, n - 1);

    return ans;
}

private int height(TreeNode root) {
    if (root == null) {
        return 0;
    }

    return 1 + Math.max(height(root.left), height(root.right));
}

private void fill(TreeNode root, List<List<String>> ans,
                  int row, int left, int right) {

    if (root == null) {
        return;
    }

    int mid = (left + right) / 2;

    ans.get(row).set(mid, String.valueOf(root.val));

    fill(root.left, ans, row + 1, left, mid - 1);
    fill(root.right, ans, row + 1, mid + 1, right);
}


}
