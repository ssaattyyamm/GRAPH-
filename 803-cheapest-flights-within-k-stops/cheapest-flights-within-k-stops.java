class Tuple{
    int value;
    int cost; 
    int stops;

    public Tuple(int value , int cost, int stops){
        this.value = value;
        this.cost = cost;
        this.stops = stops;
    }
}
class Pair{
    int value;
    int cost;

    public Pair(int value , int cost){
        this.value  = value;
        this.cost = cost;
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

        int res[] = new int[n];

        Arrays.fill(res , inf);

        res[src] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> a.stops - b.stops);

        pq.add(new Tuple(src , 0 , 0));

        while(pq.size() > 0){
            int node = pq.peek().value;
            int cost = pq.peek().cost;
            int stops = pq.peek().stops;

            pq.poll();

            for(int i=0;i<adj.get(node).size();i++){
                int curr = adj.get(node).get(i).value;
                int c = adj.get(node).get(i).cost;

                if(stops <= k && res[curr]  > c + cost){
                    res[curr] = c + cost;
                    pq.add(new Tuple(curr , res[curr] , stops+1));
                }
            }
        }

        return res[dst] == inf ? -1 : res[dst];
    }
}