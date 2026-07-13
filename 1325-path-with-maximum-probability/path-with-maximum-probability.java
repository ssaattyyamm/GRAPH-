class Pair{
    int node;
    double cost;

    public Pair(int node , double cost){
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n;i++){
            adj.add(new ArrayList<>());
        }

        int idx = 0;

        for(int[] e : edges){
            adj.get(e[0]).add(new Pair(e[1] , succProb[idx]));
            adj.get(e[1]).add(new Pair(e[0] , succProb[idx]));
            idx++;
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> Double.compare(b.cost , a.cost));

        queue.add(new Pair(start_node , 1));

        double visit[] = new double[n];

        Arrays.fill(visit , -1);

        visit[start_node] = 1;

        while(queue.size() > 0){
            Pair p = queue.poll();
            int node = p.node;
            double cost = p.cost;

            for(int i = 0 ; i < adj.get(node).size();i++){
                int curr = adj.get(node).get(i).node;
                double wt = adj.get(node).get(i).cost;

                if(visit[curr] < (cost * wt)){
                    visit[curr] = (cost * wt);
                    queue.add(new Pair(curr , visit[curr]));
                }
            }
        }
        return visit[end_node] == -1 ? 0  : visit[end_node];
    }
}