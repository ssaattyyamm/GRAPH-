class Pair{
    int node;
    int wt;
    
    public Pair(int node , int wt){
        this.node = node;
        this.wt = wt;
    }
}
class Solution {

    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    public int minReorder(int n, int[][] connections) {
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] c : connections){
            adj.get(c[0]).add(new Pair(c[1] , 1));
            adj.get(c[1]).add(new Pair(c[0] , 0));
        }

        int visit[] = new int[n];

        Arrays.fill(visit , -1);

        int cost = 0;

        return dfs(0 , visit);
    }
    public int dfs(int node , int[] visit){
        int ans = 0;

        visit[node] = 1;

        for(int i=0;i<adj.get(node).size();i++){
            int curr = adj.get(node).get(i).node;
            int cost = adj.get(node).get(i).wt;

            if(visit[curr] == -1){
                ans += cost;
                ans += dfs(curr , visit);
            }
        }
        return ans;
    }
}