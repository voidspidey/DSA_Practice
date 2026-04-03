// DFS Traversal of JAVA 
class Solution {
    public static void dfsr(ArrayList<ArrayList<Integer>> adj, int[] visited, int start,ArrayList<Integer> res){
         visited[start] = 1;
         res.add(start);
         for(int i : adj.get(start)){
             if(visited[i] == 0){
                 dfsr(adj, visited, i, res);
             }
         }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        int[] visited = new int[n];
        ArrayList<Integer> res = new ArrayList<>();
        dfsr(adj,visited, 0, res);
        return res;
        
    }
}
