class Pair{
    int node;
    long cost;

    public Pair(int node , long cost){
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        int inf = (int) 1e9;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int r[] : roads){
            adj.get(r[0]).add(new Pair(r[1] , (long)r[2]));
            adj.get(r[1]).add(new Pair(r[0] ,(long)r[2]));
        }

        long  visit[] = new long[n];
        long ways[] = new long[n];

        ways[0] = 1;

        Arrays.fill(visit , Long.MAX_VALUE);

        visit[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.cost , b.cost));

        pq.add(new Pair(0 , 0));

        while(pq.size() > 0){
            Pair p = pq.poll();
            int node = p.node;
            long cost = p.cost;

            for(int i = 0 ; i<adj.get(node).size();i++){
                int curr = adj.get(node).get(i).node;
                long wt   = adj.get(node).get(i).cost;

                if(visit[curr] > cost + wt){
                    visit[curr] = cost + wt;
                    pq.add(new Pair(curr , visit[curr]));
                    ways[curr] = ways[node];
                }
                else if(visit[curr] == cost + wt){
                    ways[curr] = (ways[curr] + ways[node]) % MOD;
                }
            }
        }
        return (int) (ways[n-1] % MOD);
    }
}