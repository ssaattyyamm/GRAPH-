class Pair {
    int first;
    int second;
    int tm;

    public Pair(int first, int second, int tm) {
        this.first = first;
        this.second = second;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length; // row
        int m = grid[0].length; // col

        Queue<Pair> q = new LinkedList<>();  /// queue with data type Pair

        int visit[][] = new int[n][m];

        int fresh = 0; // to count fresh oranges

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 2){
                    q.add(new Pair(i , j , 0));
                    visit[i][j] = 2;
                }
                else{
                    visit[i][j] = 0;
                }

                if(grid[i][j] == 1) fresh++;
            }
        }

        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        int res = 0;

        int rotten = 0;

        // applying bfs 
        while(q.size() > 0){
            int r = q.peek().first;
            int c = q.peek().second;
            int time = q.peek().tm;

            res = Math.max(res , time);

            q.remove();

            for(int d[] : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >=0 && nr < n && nc >=0 && nc < m && visit[nr][nc] == 0 && grid[nr][nc] == 1){
                    q.add(new Pair(nr , nc , time +1));
                    visit[nr][nc] = 2;
                    rotten++;
                }
            }
        }

        if(rotten != fresh) return -1;

        else return res; 
    }
}