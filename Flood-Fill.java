1class Pair{
2    int first ;
3    int second;
4
5    public Pair(int first , int second){
6        this.first = first;
7        this.second= second;
8    }
9}
10class Solution {
11    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
12        int n = image.length;
13        int m = image[0].length;
14
15        int visit[][] = new int[n][m];
16
17        int res[][] = new int[n][m];
18
19        for(int i=0;i<n;i++){
20            for(int j =0; j <m;j++){
21                res[i][j] = image[i][j];
22            }
23        }
24
25        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
26
27        int c = image[sr][sc];
28
29        bfs(sr,sc,image, visit, res,dir , n , m ,c,color);
30
31        return res;
32
33    }
34    public void bfs(int row , int col ,int[][] image , int visit[][] , int[][] res, int dir[][] ,int n , int m , int prev , int color){
35        visit[row][col] = 1;
36        res[row][col] = color;
37
38        Queue<Pair> q = new LinkedList<>();
39
40        q.add(new Pair(row , col));
41
42
43        while(!q.isEmpty()){
44            int r = q.peek().first;
45            int c = q.peek().second;
46
47            q.remove();
48
49            for(int d[] : dir){
50                int nr = r +  d[0];
51                int nc = c + d[1];
52
53                if(nr >= 0 && nr < n && nc >=0 && nc < m && visit[nr][nc] == 0 && image[nr][nc] == prev){
54                    visit[nr][nc] = 1;
55                    res[nr][nc] = color;
56
57                    q.add(new Pair(nr , nc));
58                }
59            }
60        }
61    }
62}