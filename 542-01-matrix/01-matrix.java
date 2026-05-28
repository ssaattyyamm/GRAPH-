class Node{
    int first;
    int second;
    int steps;

    public Node(int first , int second , int steps){
        this.first = first;
        this.second = second;
        this.steps = steps;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int res[][] = new int[n][m];

        int visit[][] = new int[n][m];

        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i , j , 0));
                    visit[i][j] = 1;
                }
                else{
                    visit[i][j] = 0;
                }
            }
        }
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        while(q.size() > 0){
            int r = q.peek().first;
            int c = q.peek().second;

            int steps = q.peek().steps;

            res[r][c] = steps;

            q.remove();

            for(int d[] : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < n && nc >=0 && nc <m && visit[nr][nc] != 1){
                    q.add(new Node(nr , nc , steps + 1));
                    visit[nr][nc] =1;
                }
            }
        }

        return res;
    }
}