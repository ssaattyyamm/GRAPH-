//Approach : we can use both bfs and dfs in this porblem im using dfs : im using color array which 
//helps me in tracking and colors of visited node : if the color of the visited node is same to current color , then thiss violates the concept of biparitite graph : then im returning false otherwise true

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
                if(dfs(i ,adj , 0 , colors) == false) return false;
            }
        }

        return true;
    }
    public boolean dfs(int node ,ArrayList<ArrayList<Integer>> adj , int color , int[] visited){
        visited[node] = color;

        for(Integer x : adj.get(node)){
            if(visited[x] == color) return false;

            else if(visited[x] == -1){
                if(dfs(x ,adj,1 - color,visited) == false) return false;
            }
        }

        return true;
    }
}