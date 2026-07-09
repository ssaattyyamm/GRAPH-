class Solution {
    int n , m;
    int visit[][];
    int row[];
    int col[];
    public int countBattleships(char[][] board) {
       n = board.length;
       m = board[0].length;

       visit = new int[n][m];

       for(int v[] : visit){
        Arrays.fill(v , -1);
       }

       row = new int[]{0 , -1 , 0 , 1};
       col = new int[]{-1 , 0 ,1 ,0};

       int ans = 0;

       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j] == 'X' && visit[i][j] == -1){
                dfs(i  , j , board);
                ans++;
            }
        }
       }

       return ans;
    }
    public void dfs(int i , int j ,char[][] board){
        visit[i][j] = 1;

        for(int k=0;k<4;k++){
            int nr = i + row[k];
            int nc = j + col[k];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && visit[nr][nc] == -1 && board[nr][nc] == 'X'){
                dfs(nr , nc , board);
            }
        }
    }
}