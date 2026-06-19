1class DSU{
2    int parent[];
3    int rank[];
4
5    public DSU(int n){
6        parent = new int[n];
7        rank = new int[n];
8
9        for(int i=0;i<n;i++){
10            parent[i] = i;
11            rank[i] = 0;
12        }
13    }
14    public int find(int u){
15        if(parent[u] == u) return u;
16
17        return parent[u] = find(parent[u]);
18    }
19
20    public void union(int u , int v){
21        int p1 = find(u);
22        int p2 = find(v);
23
24        int r1 = rank[p1];
25        int r2 = rank[p2];
26
27        if(p1 == p2) return;
28
29        if(r1 > r2){
30            parent[p2] = p1;
31        }
32        else if(r1 < r2){
33            parent[p1] = p2;
34        }
35        else{
36            parent[p1] = p2;
37            rank[p2]++;
38        }
39    }
40}
41class Solution {
42    public int findCircleNum(int[][] arr) {
43        int n = arr.length;
44
45        DSU dsu = new DSU(n);
46
47        for(int i=0;i<n;i++){
48            for(int j=0;j<n;j++){
49                if(arr[i][j] == 1){
50                    dsu.union(i , j);
51                }
52            }
53        }
54        int res =0;
55
56
57        for(int i=0;i<n;i++){
58            if(dsu.parent[i] == i){
59                res++;
60            }
61        }
62
63        return res;
64    }
65}