1class Solution {
2    public int findCircleNum(int[][] mat) {
3        int n = mat.length;
4
5        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
6
7        for(int i=0;i<n;i++){
8            ArrayList<Integer> list = new ArrayList<>();
9            for(int j=0;j<n;j++){
10                if(mat[i][j] == 1){
11                    list.add(j);
12                }
13            }
14            adj.add(list);
15        }
16
17
18        boolean visit[] = new boolean[n];
19
20        int res = 0;
21
22        for(int i=0;i<n;i++){
23            if(!visit[i]){
24                dfs(adj, visit, i);
25                res++;
26            }
27        }
28        return res;
29    }
30    public void dfs(ArrayList<ArrayList<Integer>> adj , boolean visit[], int curr){
31        visit[curr] = true;
32
33        for(int x : adj.get(curr)){
34            if(visit[x] == false){
35                dfs(adj,visit,x);
36            }
37        }
38    }
39}