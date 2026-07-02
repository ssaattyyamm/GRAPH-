class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int n = 0;
    int e = 0;
    public int countCompleteComponents(int len, int[][] edges) {
        // basically we can apply either bfs or dfs to solve this prblm 

        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<len;i++){
            adj.add(new ArrayList<>());
        }

        for(int e[] : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int visit[] = new int[len];
        
        Arrays.fill(visit , -1);

        int ans = 0;

        for(int i=0;i<len;i++){
            if(visit[i] == -1){
                n = 0;
                e = 0;

                dfs(i , visit);

                if(e/2 == (n * (n-1)/2)){
                    ans++;
                }

                System.out.println(n);
                System.out.println(e);
            }
        }
        return ans;
    }
    public void dfs(int node , int[] visit){
        visit[node] = 1;
        n++;

        for(int i=0;i<adj.get(node).size();i++){
            int curr = adj.get(node).get(i);
            e++;
            if(visit[curr] == -1){
                dfs(curr , visit);
            }
        }
    }
}