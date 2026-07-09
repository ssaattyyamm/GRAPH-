class Pair{
    int row;
    int col;

    public Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int n , m;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;

        int visit[][] = new int[n][m];

        for(int v[] : visit){
            Arrays.fill(v, -1);
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(visit[i][j] == -1 && grid2[i][j] == 1 && grid1[i][j] == 1){
                    if(bfs(i , j , visit , grid1 , grid2)){
                        System.out.println(i + " " + j);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public boolean bfs(int i ,int j , int[][] visit , int[][]grid1 , int[][] grid2){
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(i , j));
        visit[i][j] = 1;

        int row[] = {-1 , 0, 0 , 1};
        int col[] = {0 , -1 ,1,0};

        boolean flag = true;

        while(queue.size() > 0){
            Pair p = queue.poll();
            int r = p.row;
            int c = p.col;

            for(int k=0;k<4;k++){
                int nr = r + row[k];
                int nc = c + col[k];

                if(nr >=0 && nr < n && nc >=0 && nc < m && visit[nr][nc] == -1 && grid2[nr][nc] == 1){
                    if(grid1[nr][nc] != 1) flag = false;
                    else{
                        visit[nr][nc] = 1;
                        queue.add(new Pair(nr , nc));
                    }
                }
            }
        }

        return flag;
    }
}