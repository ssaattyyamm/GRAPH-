class Pair{
    int node;
    int wt;

    public Pair(int node , int wt){
        this.node = node;
        this.wt = wt;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = (int)1e9;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int t[] : times){
            adj.get(t[0]).add(new Pair(t[1], t[2]));
        }

        int dist[] = new int[n+1];

        Arrays.fill(dist,inf);

        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);

        pq.add(new Pair(k , 0));

        while(pq.size() > 0){
            int node = pq.peek().node;
            int wt = pq.peek().wt;

            pq.poll();

            for(int i=0;i<adj.get(node).size();i++){
                int curr = adj.get(node).get(i).node;
                int cost = adj.get(node).get(i).wt;

                if(dist[curr] > wt  + cost){
                    dist[curr] = wt + cost;
                    pq.add(new Pair(curr , wt + cost));
                }
            }
        }

        int ans = 0;

        for(int i=1;i<=n;i++){
            if(dist[i] == inf) return -1;
            ans = Math.max(ans , dist[i]);
        }

        return ans;
    }
}