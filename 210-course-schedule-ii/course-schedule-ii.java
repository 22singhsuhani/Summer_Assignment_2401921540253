class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];

        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for(int[] e : prerequisites) {
            int u = e[1];
            int v = e[0];

            adj[u].add(v);
            indegree[v]++;
        }

        // Add nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()) {

            int node = q.poll();

            ans[idx++] = node;

            for(int it : adj[node]) {

                indegree[it]--;

                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Check cycle
        if(idx != numCourses) {
            return new int[0];
        }

        return ans;
    }
}