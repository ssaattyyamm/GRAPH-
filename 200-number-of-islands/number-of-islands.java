class Solution {
    int visit[][];

    public int numIslands(char[][] arr) {
        int n =  arr.length;

        int m = arr[0].length;

        visit= new int[n][m];

        int row[]={-1 , 0 ,0 ,1};

        int col[]={0, -1,1,0};

        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j] != 1 && arr[i][j] == '1'){
                    cnt++;
                    dfs(arr , i , j , row , col);
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] arr, int r, int c, int[] row, int[] col) {
        visit[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + row[i];
            int nc = c + col[i];

            if(nr >= 0 && nr < arr.length  && nc >= 0 && nc < arr[0].length && visit[nr][nc] != 1 && arr[nr][nc] == '1'){
                dfs(arr ,nr , nc ,row , col);
            }
        }
    }
}