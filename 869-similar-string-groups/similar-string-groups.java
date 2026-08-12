class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] vis = new boolean[n];
        int groups = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                groups++;
                dfs(i, strs, vis);
            }
        }
        return groups;
    }

    void dfs(int i, String[] strs, boolean[] vis) {
        vis[i] = true;

        for (int j = 0; j < strs.length; j++) {
            if (!vis[j] && similar(strs[i], strs[j])) {
                dfs(j, strs, vis);
            }
        }
    }

    boolean similar(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 0 || diff == 2;
    }
}