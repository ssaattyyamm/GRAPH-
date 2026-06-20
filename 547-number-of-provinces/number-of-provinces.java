class Solution {
    public int findCircleNum(int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = arr.length;

        boolean visit[] = new boolean[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        int cnt = 0;

        for(int i=0;i<n;i++){
            if(!visit[i]){
                cnt++;
                dfs(i , visit , adj);
            }
        }
        return cnt;
    }
    public void dfs(int v , boolean[] visit , ArrayList<ArrayList<Integer>> adj){
        visit[v] = true;

        for(int i=0;i<adj.get(v).size();i++){
            int next = adj.get(v).get(i);

            if(!visit[next]){
                dfs(next , visit , adj);
            }
        }
    }
}