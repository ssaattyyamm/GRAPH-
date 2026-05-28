class Pair{
    int first;
    int second;
    
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};

        int[][] visit = new int[n][m];

        int res = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && visit[i][j] == 0){
                    res++;
                    bfs(i ,j , grid, visit, dir , n , m);
                }
            }
        }
        return res;
    }
    public void bfs(int  row , int col , char[][] grid , int[][] visit , int[][] dir , int n , int m ){
        visit[row][col] = 1;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row , col));

        while(q.size() > 0){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int d[] : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >=0 && nr < n && nc >= 0 && nc < m && visit[nr][nc] == 0 && grid[nr][nc] == '1'){
                    visit[nr][nc] = 1;
                    q.add(new Pair(nr , nc));
                }
            }
        }
    }
}