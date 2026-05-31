class Pair{
    int val;
    int color;

    public Pair(int val , int color){
        this.val = val;
        this.color = color;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; // no of vertices

        int colors[] = new int[n]; // color array which also represennt the visited array

        Arrays.fill(colors , -1); // minus one fill 

        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int j=0;j<graph[i].length;j++){
                curr.add(graph[i][j]);
            }
            adj.add(curr);
        }

        // connected componenet concept : 
        for(int i=0;i<n;i++){
            if(colors[i] == -1){
                if(bfs(i ,adj , 0 , colors) == false) return false;
            }
        }
        return true;
    }
    public boolean bfs(int node , ArrayList<ArrayList<Integer>> adj , int color , int[] visited){
        Queue<Pair> q = new LinkedList<>();

        visited[node] = color;

        q.add(new Pair(node , color));

        while(q.size() > 0){
            int n = q.peek().val;

            int c = q.peek().color;

            q.remove();

            for(Integer x : adj.get(n)){
                if(visited[x] == c) return false;

                if(visited[x] == -1){
                    visited[x] = 1 - c;

                    q.add(new Pair(x , 1 - c));
                }

            } 
        }

        return true;
    }
}