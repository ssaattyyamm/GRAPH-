class Pair{
    int node;
    int dist;

    public Pair(int node , int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        int inf = (int)1e9;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int r[] : roads){
            adj.get(r[0]).add(new Pair(r[1] , r[2]));
            adj.get(r[1]).add(new Pair(r[0] , r[2]));
        }

        int dis[] =  new int[n+1];

        Arrays.fill(dis , inf);

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(1 , inf));

        while(queue.size() > 0){
            int node = queue.peek().node;
            int dist = queue.peek().dist;

            queue.poll();

            for(int i=0;i<adj.get(node).size();i++){
                int curr = adj.get(node).get(i).node;
                int val = adj.get(node).get(i).dist;

                if(dis[curr] > Math.min(dist , val)){
                    dis[curr] = Math.min(dist , val);
                    queue.add(new Pair(curr , dis[curr]));
                }
            }
        }
        return dis[n];
    }
}