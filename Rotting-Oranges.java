1class Pair {
2    int first;
3    int second;
4    int tm;
5
6    public Pair(int first, int second, int tm) {
7        this.first = first;
8        this.second = second;
9        this.tm = tm;
10    }
11}
12
13class Solution {
14    public int orangesRotting(int[][] grid) {
15        int n = grid.length; // row
16        int m = grid[0].length; // col
17
18        Queue<Pair> q = new LinkedList<>();  /// queue with data type Pair
19
20        int visit[][] = new int[n][m];
21
22        int fresh = 0; // to count fresh oranges
23
24        for (int i = 0; i < n; i++) {
25            for (int j = 0; j < m; j++) {
26                if(grid[i][j] == 2){
27                    q.add(new Pair(i , j , 0));
28                    visit[i][j] = 2;
29                }
30                else{
31                    visit[i][j] = 0;
32                }
33
34                if(grid[i][j] == 1) fresh++;
35            }
36        }
37
38        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
39
40        int res = 0;
41
42        int rotten = 0;
43
44        // applying bfs 
45        while(q.size() > 0){
46            int r = q.peek().first;
47            int c = q.peek().second;
48            int time = q.peek().tm;
49
50            res = Math.max(res , time);
51
52            q.remove();
53
54            for(int d[] : dir){
55                int nr = r + d[0];
56                int nc = c + d[1];
57
58                if(nr >=0 && nr < n && nc >=0 && nc < m && visit[nr][nc] == 0 && grid[nr][nc] == 1){
59                    q.add(new Pair(nr , nc , time +1));
60                    visit[nr][nc] = 2;
61                    rotten++;
62                }
63            }
64        }
65
66        if(rotten != fresh) return -1;
67
68        else return res; 
69    }
70}