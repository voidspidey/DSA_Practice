// Find Eventual safe states 
// DFS and BFS



class Solution {
    public boolean dfs(int start, ArrayList<ArrayList<Integer>> edges, int[] vis, int[] pathVis,int[] check){
        vis[start] = 1;
        pathVis[start] = 1;
        check[start] = 0;
        for(int nd : edges.get(start)){
            if(vis[nd] == 0){
                if(dfs(nd,edges,vis,pathVis,check)){
                    return true;
                }
            }
            else if(pathVis[nd] == 1 ){
                return true;
            }
        }


        check[start] = 1;
        pathVis[start] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        // int[]  vis = new int[n];
        // int[] pathVis = new int[n];
        // int[] check = new int[n];
        for(int i  = 0; i < V; i++){
            lst.add(new ArrayList<>());
        }
       
        for (int i = 0; i < V; i++) {
            for (int v : graph[i]) {
                lst.get(i).add(v);
            }
        }

        ArrayList<ArrayList<Integer>> adjrev = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adjrev.add(new ArrayList<>());
        }
        
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it: lst.get(i)){
                adjrev.get(it).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> safenodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            safenodes.add(node);
            
            for(int it: adjrev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
            
        }
        Collections.sort(safenodes);
        return safenodes;
    }
} 
