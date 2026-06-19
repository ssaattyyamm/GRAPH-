class DSU{
    int parent[];
    int rank[];

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int u){
        if(parent[u] == u) return u;

        return parent[u] = find(parent[u]);
    }

    public void union(int u , int v){
        int p1 = find(u);
        int p2 = find(v);

        int r1 = rank[p1];
        int r2 = rank[p2];

        if(p1 == p2) return;

        if(r1 > r2){
            parent[p2] = p1;
        }
        else if(r1 < r2){
            parent[p1] = p2;
        }
        else{
            parent[p1] = p2;
            rank[p2]++;
        }
    }
}
class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;

        DSU dsu = new DSU(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1){
                    dsu.union(i , j);
                }
            }
        }
        int res =0;


        for(int i=0;i<n;i++){
            if(dsu.parent[i] == i){
                res++;
            }
        }

        return res;
    }
}