1class Pair{
2    int first;
3    int second;
4    
5    public Pair(int first , int second){
6        this.first = first;
7        this.second = second;
8    }
9}
10class Solution {
11    public int numIslands(char[][] grid) {
12        int n = grid.length;
13        int m = grid[0].length;
14
15        int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
16
17        int[][] visit = new int[n][m];
18
19        int res = 0;
20
21        for(int i=0;i<n;i++){
22            for(int j=0;j<m;j++){
23                if(grid[i][j] == '1' && visit[i][j] == 0){
24                    res++;
25                    bfs(i ,j , grid, visit, dir , n , m);
26                }
27            }
28        }
29        return res;
30    }
31    public void bfs(int  row , int col , char[][] grid , int[][] visit , int[][] dir , int n , int m ){
32        visit[row][col] = 1;
33
34        Queue<Pair> q = new LinkedList<>();
35
36        q.add(new Pair(row , col));
37
38        while(q.size() > 0){
39            int r = q.peek().first;
40            int c = q.peek().second;
41            q.remove();
42
43            for(int d[] : dir){
44                int nr = r + d[0];
45                int nc = c + d[1];
46
47                if(nr >=0 && nr < n && nc >= 0 && nc < m && visit[nr][nc] == 0 && grid[nr][nc] == '1'){
48                    visit[nr][nc] = 1;
49                    q.add(new Pair(nr , nc));
50                }
51            }
52        }
53    }
54}