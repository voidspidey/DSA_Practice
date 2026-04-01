
// Problem: Alien Dictionary
// Approach: BFS (TopoSort)
// Time Complexity: O(N * M)
// Space Complexity: O(N * M)class Solution {
    public List<Integer> toposort(ArrayList<ArrayList<Integer>> adj, int n, int[] present){
        
        int[] indegree = new int[26];
        for(int i = 0; i <n; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(present[i] == 1 && indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
    public String findOrder(String[] words) {
        // code here
        int n = 26;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] present = new int[26];
        for(String word : words){
            for(char c : word.toCharArray()){
                present[c - 'a'] = 1;
            }
        }
        
        for(int i = 0; i < words.length - 1; i++){
            String s1 = words[i];
            String s2 = words[i + 1];
            
            if( s1.length() > s2.length() && s1.startsWith(s2)) return "";
            
            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';
                    
                    if(!adj.get(u).contains(v)){
                        adj.get(u).add(v);
                    }
                    break;
                }
            }
        }
        
        List<Integer> topo = toposort(adj, n, present);
        
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(present[i] == 1) count++;
        }
        int topoCount = 0;
        
           for (int node : topo) {
            if (present[node] == 1) topoCount++;
        }
        

        if (topoCount != count) return "";

        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            if (present[it] == 1) {
                ans.append((char)(it + 'a'));
            }
        }

        return ans.toString();
    }
}
