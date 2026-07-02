class Tuple{
    int row;
    int col;
    int health;

    public Tuple(int row , int col ,int health){
        this.row = row;
        this.col = col;
        this.health = health;
    }
}
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int h) {
        int inf = (int) 1e9;

        int n = grid.size();
        int m  = grid.get(0).size();

        int arr[][] = new int[n][m];

        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                arr[i][j] = grid.get(i).get(j);
            }
        }

        int visit[][] = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(visit[i] , inf);
        }

        if(arr[0][0] == 0) visit[0][0] = 0;
        if(arr[0][0] == 1) visit[0][0] = 1;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> a.health - b.health);

        pq.add(new Tuple(0 , 0 , visit[0][0]));

        int row[] = {0 , 0 , -1 , 1};
        int col[] = {1 , -1 , 0 , 0};

        while(pq.size() > 0){
            int r = pq.peek().row;
            int c = pq.peek().col;
            int health = pq.peek().health;

            pq.poll();

            for(int i=0;i<4;i++){
                int nr = r + row[i];
                int nc = c + col[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m  && health + arr[nr][nc] < visit[nr][nc]){
                    visit[nr][nc] = health + arr[nr][nc];
                    pq.add(new Tuple(nr  , nc , visit[nr][nc]));
                }
            }
        }

        return h - visit[n-1][m-1] >= 1;
    }
}