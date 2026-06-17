class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int inf = (int) 1e9;

        int dist[][] = new int[n][n];

        for(int d[] : dist){
            Arrays.fill(d, inf);
        }

        for(int e[] : edges){
            int row = e[0];
            int col = e[1];
            int wt = e[2];

            dist[row][col] = wt;
            dist[col][row] = wt;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) dist[i][j] = 0;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k =0;k<n;k++){
                    if(dist[j][i] != inf && dist[i][k] != inf){
                        dist[j][k] = Math.min(dist[j][k] , dist[j][i] + dist[i][k]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;

        int city = -1;

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                 if(dist[i][j] <= distanceThreshold) cnt++;
            }
            if(cnt <= min){
                min = cnt;
                city = Math.max(city , i);
            }
        }

        return city;
    }
}