1class Node{
2    int first;
3    int second;
4    int steps;
5
6    public Node(int first , int second , int steps){
7        this.first = first;
8        this.second = second;
9        this.steps = steps;
10    }
11}
12class Solution {
13    public int[][] updateMatrix(int[][] mat) {
14        int n = mat.length;
15        int m = mat[0].length;
16
17        int res[][] = new int[n][m];
18
19        int visit[][] = new int[n][m];
20
21        Queue<Node> q = new LinkedList<>();
22
23        for(int i=0;i<n;i++){
24            for(int j=0;j<m;j++){
25                if(mat[i][j] == 0){
26                    q.add(new Node(i , j , 0));
27                    visit[i][j] = 1;
28                }
29                else{
30                    visit[i][j] = 0;
31                }
32            }
33        }
34        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
35
36        while(q.size() > 0){
37            int r = q.peek().first;
38            int c = q.peek().second;
39
40            int steps = q.peek().steps;
41
42            res[r][c] = steps;
43
44            q.remove();
45
46            for(int d[] : dir){
47                int nr = r + d[0];
48                int nc = c + d[1];
49
50                if(nr >= 0 && nr < n && nc >=0 && nc <m && visit[nr][nc] != 1){
51                    q.add(new Node(nr , nc , steps + 1));
52                    visit[nr][nc] =1;
53                }
54            }
55        }
56
57        return res;
58    }
59}