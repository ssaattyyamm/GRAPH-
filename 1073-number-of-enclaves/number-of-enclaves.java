class Pair{
    int row;
    int col;
}
class Solution {
    int row[];
    int col[];
    int n , m;
    public int numEnclaves(int[][] grid) {
         n = grid.length;
         m = grid[0].length;

        row = new int[]{0 , -1 , 1, 0};
        col = new int[]{-1 ,0 , 0 , 1};

        int visit[][] = new int[n][m];

        for(int v[] : visit){
            Arrays.fill(v , -1);
        }

        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0;i<n;i++){
            for(int j  = 0 ; j < m;j++){
                if((i == 0 || i == n-1 || j == 0 ||  j == m-1) && (visit[i][j] == -1 && grid[i][j] == 1)){
                    dfs(grid , visit , i , j);
                }
            }
        }

        int res = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(visit[i][j] == -1 && grid[i][j] == 1) res++;
            }
        }

        return res;
    }
    public void dfs(int[][] grid , int[][] visit , int r , int c){
        visit[r][c] = 1;

        for(int i = 0 ; i < 4;i++){
            int nr = r  + row[i];
            int nc = c + col[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && visit[nr][nc] != 1 && grid[nr][nc] == 1){
                dfs(grid , visit , nr , nc);
            }
        }
    }
}