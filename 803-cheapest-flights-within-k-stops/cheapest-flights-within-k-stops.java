class Tuple{
    int node;
    int cost;
    int stop;

    public Tuple(int node , int cost , int stop){
        this.node = node;
        this.cost = cost;
        this.stop = stop;
    }
}
class Pair{
    int node;
    int wt;
    
    public Pair(int node , int wt){
        this.node = node;
        this.wt = wt;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {   
        int inf = (int) 1e9;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int f[] : flights){
            adj.get(f[0]).add(new Pair(f[1],f[2]));
        }

        int dist[][] = new int[n][k+2];

        for(int d[] : dist){
            Arrays.fill(d , inf);
        }

        for(int i=0;i<=k;i++){
            dist[src][i] = 0;
        }

        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(src , 0 , 0));

        while(queue.size() > 0){
            int node = queue.peek().node;
            int cost = queue.peek().cost;
            int stop = queue.peek().stop;

            queue.poll();

            for(int i=0;i<adj.get(node).size();i++){
                int curr = adj.get(node).get(i).node;
                int wt = adj.get(node).get(i).wt;

                if(stop + 1 < k + 2 && dist[curr][stop + 1] > (cost + wt)){
                    dist[curr][stop+1] = cost + wt;
                    queue.add(new Tuple(curr , cost + wt , stop + 1));
                }
            }
        }

        int ans = inf;

        for(int i=0;i<=k+1;i++){
            ans = Math.min(dist[dst][i], ans);
        }

        return ans == inf ? -1 : ans;
    }
}