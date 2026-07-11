class Tuple {
    int node;
    int stops;
    int wt;

    public Tuple(int node, int stops, int wt) {
        this.node = node;
        this.stops = stops;
        this.wt = wt;
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
            adj.get(f[0]).add(new Pair(f[1] , f[2]));
        }

        int visit[][] = new int[n][1000];

        for(int v[] : visit){
            Arrays.fill(v  , inf);
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);

        visit[src][0] = 0;

        pq.add(new Tuple(src , 0 , 0));

        while(pq.size() > 0){
            Tuple t = pq.poll();
            int node = t.node;
            int stops = t.stops;
            int wt = t.wt;

            if(stops  > k + 1) continue;

            for(int i = 0 ; i < adj.get(node).size();i++){
                int curr = adj.get(node).get(i).node;
                int cost = adj.get(node).get(i).wt;

                if(visit[curr][stops + 1]  > wt + cost){
                    visit[curr][stops + 1] = wt + cost;
                    pq.add(new Tuple(curr , stops + 1, visit[curr][stops + 1]));
                }
            }
        }

        int min = inf;

        for(int i = 0 ; i <= k + 1;i++){
            min = Math.min(min , visit[dst][i]);
        }

        return min == inf ? -1 : min;
    }
}