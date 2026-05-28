class Pair{
    int first ;
    int second;

    public Pair(int first , int second){
        this.first = first;
        this.second= second;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int visit[][] = new int[n][m];

        int res[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j =0; j <m;j++){
                res[i][j] = image[i][j];
            }
        }

        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        int c = image[sr][sc];

        bfs(sr,sc,image, visit, res,dir , n , m ,c,color);

        return res;

    }
    public void bfs(int row , int col ,int[][] image , int visit[][] , int[][] res, int dir[][] ,int n , int m , int prev , int color){
        visit[row][col] = 1;
        res[row][col] = color;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row , col));


        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;

            q.remove();

            for(int d[] : dir){
                int nr = r +  d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < n && nc >=0 && nc < m && visit[nr][nc] == 0 && image[nr][nc] == prev){
                    visit[nr][nc] = 1;
                    res[nr][nc] = color;

                    q.add(new Pair(nr , nc));
                }
            }
        }
    }
}