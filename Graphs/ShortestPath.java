// Shortest path in Directed Acyclic Graph
//Time complexity = O(V+ E)
// SC = O(V+ E)
class Pair{
    int first;
    int second;
    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    public void toposort(int node, ArrayList<ArrayList<Pair>> adj ,int[] vis, Stack<Integer>st ){
        vis[node] = 1;
        for(int i= 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                toposort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for( int i = 0; i <V; i++){
            if(vis[i] == 0){
                toposort(i, adj,vis,st);
            }
        }
        
        int[] dist = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = (int)(1e9);
        }
        
        // src = 0
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            for(int i =0; i < adj.get(node).size(); i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                } 
            }
        }
        for( int i = 0; i < V; i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}
