class Tuple {
    int row;
    int col;
    int max;

    public Tuple(int row , int col , int max){
        this.row = row;
        this.col = col;
        this.max = max;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int inf = (int) 1e9;
        int n = heights.length;

        int m = heights[0].length;
        // nice question:


        int res[][] = new int[n][m];

        for(int r[] : res){
            Arrays.fill(r , inf);
        }

        res[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.max - b.max);

        int row[] = {-1 , 0, 0,1};
        int col[] = {0,-1,1,0};

        pq.add(new Tuple(0,0,0));

        // int res = Integer.MAX_VALUE;

        while(pq.size() > 0){
            int r = pq.peek().row;
            int c = pq.peek().col;
            int max = pq.peek().max;

            pq.poll();

            for(int i=0;i<4;i++){
                int nr = r + row[i];
                int nc = c + col[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int diff = Math.abs(heights[nr][nc] - heights[r][c]);

                    diff = Math.max(diff , max);

                    if(diff < res[nr][nc]){
                        res[nr][nc] = diff;
                        pq.add(new Tuple(nr ,nc , diff));
                    }
                }
            }
        }
        return res[n-1][m-1];
    }
}