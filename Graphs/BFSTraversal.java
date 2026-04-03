// BFS traversal Of Graph
class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        int[] visited = new int[n];
        Queue<Integer> qc = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        visited[start] = 1;
        qc.add(start);
        
        while(!qc.isEmpty()){
            int curr = qc.poll();
            res.add(curr);
            for(int x : adj.get(curr))
            {
                if(visited[x] == 0){
                    qc.add(x);
                    visited[x] = 1;
                }
            }
        }
        
        return res;
    }
}
