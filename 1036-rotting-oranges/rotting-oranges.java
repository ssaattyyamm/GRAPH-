class Solution {
    class Tuple{
        int row;
        int col;
        int min;

        public Tuple(int row , int col , int min){
            this.row = row;
            this.col = col;
            this.min = min;
        }
    }
    public int orangesRotting(int[][] grid) {
        int  n = grid.length;
        int m = grid[0].length;

        Queue<Tuple> queue = new LinkedList<>();

        for(int i = 0; i < n;i++){
            for(int j = 0 ; j < m;j++){
                if(grid[i][j] == 2){
                    queue.add(new Tuple(i , j , 0));
                    grid[i][j] = 0;
                }
            }
        }

        int ans = 0;

        int r[] = {-1 , 1 , 0 , 0};
        int c[] ={0 , 0 , -1 , 1};

        while(queue.size() > 0){
            Tuple t = queue.poll();
            int row = t.row;
            int col = t.col;
            int min = t.min;

            ans = Math.max(ans , min);


            for(int i = 0 ; i < 4;i++){
                int nr = row + r[i];
                int nc = col + c[i];

                if(nr >=0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    queue.add(new Tuple(nr , nc , min + 1));
                }
            }
        }

        for(int i = 0 ; i < n;i++){
            for(int  j = 0 ; j < m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans;
    }
}