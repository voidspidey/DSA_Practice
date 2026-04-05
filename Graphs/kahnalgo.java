// Topological sort with BFS Approach using Kahn's Algorithm
//Time Complexity 	O(V + E)
// Space Complexity 	O(V + E)
class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        

         for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }

        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int it : adj.get(node)){
                 indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        return ans;
    }
}
