class Tuple {
    int dist;
    int row;
    int col;

    public Tuple(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int inf = (int)1e9;

        int n = grid.length;

        int res[][] = new int[n][n];

        if(grid[0][0] == 1) return -1;

        for (int r[] : res) {
            Arrays.fill(r, inf);
        }

        res[0][0] = 0;

        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(0, 0, 0));

        int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // how can i do this : 

        while(queue.size() > 0){
            int dist = queue.peek().dist;
            int r = queue.peek().row;
            int c = queue.peek().col;

            queue.remove();

            for(int i=0;i<8;i++){
                int nr = r + row[i];
                int nc = c + col[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] != 1){
                    if(dist + 1 < res[nr][nc]){
                        res[nr][nc] = dist +1;
                        queue.add(new Tuple(dist + 1 , nr , nc));
                    }
                }
            }
        }

        return res[n-1][n-1] == inf ? -1 : res[n-1][n-1] +1;
    }
}