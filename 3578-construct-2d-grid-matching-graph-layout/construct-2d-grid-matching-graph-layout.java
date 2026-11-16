import java.util.*;

class Solution {

    public int[][] constructGridLayout(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build adjacency list
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // Find node having minimum degree
        int corner = 0;

        for (int i = 1; i < n; i++) {
            if (graph[i].size() < graph[corner].size()) {
                corner = i;
            }
        }

        boolean[] seen = new boolean[n];
        seen[corner] = true;

        // Construct first row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(corner);

        int cornerDegree = graph[corner].size();

        while (firstRow.size() == 1 ||
               graph[firstRow.get(firstRow.size() - 1)].size() == cornerDegree + 1) {

            int last = firstRow.get(firstRow.size() - 1);

            // Sort neighbors by degree
            graph[last].sort((a, b) ->
                graph[a].size() - graph[b].size()
            );

            for (int v : graph[last]) {

                if (!seen[v] &&
                    (graph[v].size() == cornerDegree ||
                     graph[v].size() == cornerDegree + 1)) {

                    firstRow.add(v);
                    seen[v] = true;
                    break;
                }
            }
        }

        // Calculate rows and columns
        int cols = firstRow.size();
        int rows = n / cols;

        int[][] ans = new int[rows][cols];

        // Fill first row
        for (int j = 0; j < cols; j++) {
            ans[0][j] = firstRow.get(j);
        }

        // Fill remaining rows
        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int prev = ans[i - 1][j];

                for (int v : graph[prev]) {

                    if (!seen[v]) {
                        ans[i][j] = v;
                        seen[v] = true;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}