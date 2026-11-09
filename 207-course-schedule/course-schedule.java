import java.util.*;

class Solution { 
    public boolean canFinish(int n, int[][] pre) { 
        // 1. Initialize adjacency list for all n nodes (0 to n-1)
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0; i < n; i++){ 
            adj.add(new ArrayList<>()); 
        }

        // 2. Build the graph and calculate indegrees
        int[] indegree = new int[n]; 
        for(int i = 0; i < pre.length; i++){ 
            int a = pre[i][0], b = pre[i][1]; 
            adj.get(b).add(a); 
            indegree[a]++; 
        }

        // 3. Add all sources (nodes with 0 incoming edges) to the queue
        Queue<Integer> q = new LinkedList<>(); 
        List<Integer> ans = new ArrayList<>(); 
        for(int i = 0; i < n; i++){ 
            if(indegree[i] == 0) q.add(i); 
        }

        // 4. Process Kahn's algorithm
        while(q.size() > 0){ 
            int front = q.remove(); 
            ans.add(front); 
            
            // Fixed: Added 'adj.' prefix before get()
            for(int ele : adj.get(front)){ 
                indegree[ele]--; 
                if(indegree[ele] == 0) q.add(ele); 
            } 
        } 

        // If the topological sort includes all nodes, no cycle exists
        return (ans.size() == n); 
    } 
}
