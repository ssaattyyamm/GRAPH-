class Pair{
    int node;
    int color;

    public Pair(int node , int color){
        this.node = node;
        this.color = color;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        // bfs and dfs

        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int j=0;j<graph[i].length;j++){
                curr.add(graph[i][j]);
            }
            adj.add(curr);
        }

        int color[] = new int[n];

        Arrays.fill(color , -1);


        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(dfs(i , adj , color , 0) == false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node ,ArrayList<ArrayList<Integer>> adj , int[] color , int c){
        color[node] = c;

        for(int i=0;i<adj.get(node).size();i++){
            int curr = adj.get(node).get(i);

            if(color[curr] == -1){
                if(dfs(curr , adj , color , 1 - c) == false) return false;
            }
            else{
                if(color[curr] == c) return false;
            }
        }
        return true;
    }
}