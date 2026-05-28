class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1){
                    list.add(j);
                }
            }
            adj.add(list);
        }


        boolean visit[] = new boolean[n];

        int res = 0;

        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(adj, visit, i);
                res++;
            }
        }
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj , boolean visit[], int curr){
        visit[curr] = true;

        for(int x : adj.get(curr)){
            if(visit[x] == false){
                dfs(adj,visit,x);
            }
        }
    }
}