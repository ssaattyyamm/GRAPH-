class Pair{
    int node;
    int cost;
    
    public Pair(int node , int cost){
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = (int) 1e9;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i < n + 1;i++){
            adj.add(new ArrayList<>());
        }

        for(int t[] : times){
            adj.get(t[0]).add(new Pair(t[1] , t[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);

        int visit[] = new int[n + 1];

        Arrays.fill(visit , inf);

        visit[k] = 0;

        pq.add(new Pair(k , 0));

        int max = Integer.MIN_VALUE;

        while(pq.size() > 0){
            Pair p = pq.poll();
            int node = p.node;
            int cost = p.cost;

            for(int i = 0; i< adj.get(node).size();i++){
                int curr = adj.get(node).get(i).node;
                int wt   = adj.get(node).get(i).cost;

                if(visit[curr] > wt + cost){
                    visit[curr] = wt + cost;
                    pq.add(new Pair(curr , visit[curr]));
                }
            }
        }
        for(int i = 1;i < visit.length;i++){
            if(visit[i] == inf) return -1;
            max = Math.max(max , visit[i]);
        }
        return max;
    }
}