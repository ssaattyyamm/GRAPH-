class Pair{
    int row;
    int col;
    public Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void solve(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int visit[][] = new int[n][m];

        Queue<Pair> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 'X'){
                    visit[i][j] = 1;
                }
                if(i == 0 || i == n-1 || j==0 || j == m-1){
                    System.out.println(i  + " " + j);
                    if(arr[i][j] == 'O'){
                        visit[i][j] = 1;
                        queue.add(new Pair(i , j));
                    }
                }
            }
        }

        int row[] = {-1 , 1 , 0 ,0};
        int col[] = {0,0,-1 ,1};

        while(queue.size() > 0){
            int  r = queue.peek().row;
            int c = queue.peek().col;

            queue.poll();

            for(int i=0;i<4;i++){
                int nr = r + row[i];
                int nc = c + col[i];

                if(nr >=0 && nr <n && nc >= 0 && nc < m && visit[nr][nc] == 0){
                    visit[nr][nc] = 1;
                    queue.add(new Pair(nr , nc));
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(visit[i][j]);
                if(visit[i][j] == 0){
                    arr[i][j] = 'X';
                }
            }
            System.out.println();
        }

        
    }
}