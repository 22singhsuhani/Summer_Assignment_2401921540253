class Solution {

    int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        // Initially, every character is its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Create equivalent character groups
        for (int i =0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder ans = new StringBuilder();

        // Find smallest equivalent character
        for (char ch : baseStr.toCharArray()) {
            int root = find(ch - 'a');
            ans.append((char)(root + 'a'));
        }

        return ans.toString();
    }

    int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        // Always make the smaller character the parent
        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }
}