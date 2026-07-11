class Tuple{
    int row;
    int col;
    int wt;

    public Tuple(int row , int col , int wt){
        this.row = row;
        this.col = col;
        this.wt = wt;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int inf = (int) 1e9;
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

        int row[] = {-1 , -1 ,-1 ,0  , 0 , 1 , 1, 1};
        int col[] = {-1 , 0 , 1 , -1  ,1 ,-1 ,0 ,1};

        int visit[][] = new int[n][m];

        for(int v[] : visit){
            Arrays.fill(v , inf);
        }

        visit[0][0] = 1;

        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(0 , 0 , 1));

        while(queue.size() > 0){
            Tuple t = queue.poll();

            int r = t.row;
            int c = t.col;
            int wt = t.wt;

            for(int i=0;i<8;i++){
                int nr = r + row[i];
                int nc = c + col[i];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && visit[nr][nc] > 1 + wt && grid[nr][nc] == 0){
                    visit[nr][nc] = 1 + wt;
                    queue.add(new Tuple(nr , nc , visit[nr][nc]));
                }
            }
        }

        return visit[n-1][m-1] == inf ? -1 : visit[n-1][m-1];
    }
}