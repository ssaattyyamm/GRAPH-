class Tuple {
    int row;
    int col;
    int cost;

    public Tuple(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}

class Solution {
    public int minimumEffortPath(int[][] arr){
        int inf = (int)1e9;

        int n = arr.length;
        int m = arr[0].length;

        int dist[][] = new int[n][m];

        for(int d[] : dist){
            Arrays.fill(d,inf);
        }

        dist[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);

        pq.add(new Tuple(0 , 0 , 0));

        int row[] = {-1, 0 ,0 ,1};
        int col[] = {0,-1,1,0};

        while(pq.size() > 0){
            int r = pq.peek().row;
            int c = pq.peek().col;
            int cost = pq.peek().cost;

            pq.poll();

            for(int i=0;i<4;i++){
                int nr = r + row[i];
                int nc = c + col[i];

                // int dis = Math.abs(arr[r][c] - arr[nr][nc]);

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && dist[nr][nc] > Math.max(cost ,Math.abs(arr[r][c] - arr[nr][nc]))){
                    dist[nr][nc] =   Math.max(cost ,Math.abs(arr[r][c] - arr[nr][nc]));
                    System.out.println(dist[nr][nc]);
                    pq.add(new Tuple(nr , nc , dist[nr][nc]));
                }
            }
        }

        return dist[n-1][m-1] ; 
    }
}