class Solution {
    int n, m;
    int visit[][];
    int row[];
    int col[];
    int ans = 0;

    public int islandPerimeter(int[][] grid) {
        //i figure out the solution
        n = grid.length;
        m = grid[0].length;

        visit = new int[n][m];

        row = new int[] { -1, 0, 0, 1 };
        col = new int[] { 0, 1, -1, 0 };

        for (int v[] : visit) {
            Arrays.fill(v, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == -1 && grid[i][j] == 1) {
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int[][] grid) {
        visit[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int nr = i + row[k];
            int nc = j + col[k];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 0) {
                ans++;
            }
            else{
                if(visit[i][j] == -1){
                    dfs(i , j , grid);
                }
            }


        }
    }
}