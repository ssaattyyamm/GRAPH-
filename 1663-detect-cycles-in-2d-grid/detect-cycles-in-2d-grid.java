class Quad{
    int r;
    int c;
    int pr;
    int pc;

    public Quad(int r , int c , int pr , int pc){
        this.r  = r;
        this.c = c;
        this.pr = pr;
        this.pc = pc;
    }
}
class Solution {
    int n;
    int m;
    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int visit[][] = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(visit[i] , -1);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j] == -1){
                    if(bfs(visit , grid , i , j) == true) return true;
                }
            }
        }
        return false;
    }
    public boolean bfs(int[][] visit , char[][] grid , int  r1, int c1){
        Queue<Quad> queue = new LinkedList<>();

        queue.add(new Quad(r1 , c1  , -1 , -1));

        visit[r1][c1] = 1;

        int row[] = {0 , 0 , -1 ,1};
        int col[] = {-1 , 1 ,0 , 0};

        while(queue.size() > 0){
            int r = queue.peek().r;
            int c = queue.peek().c;
            int pr = queue.peek().pr;
            int pc = queue.peek().pc;

            queue.poll();

            for(int i=0;i<4;i++){
                int nr = r + row[i];
                int nc = c + col[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[r][c] == grid[nr][nc]){
                    if(visit[nr][nc] == -1){
                        queue.add(new Quad(nr , nc , r , c));
                        visit[nr][nc] = 1;
                    }
                    else if(nr != pr  && nc != pc) return true;
                }
            } 
        }

        return false;
    }
}