import java.util.*;

class Pair {
    int value;
    long cost;

    public Pair(int value, long cost) {
        this.value = value;
        this.cost = cost;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        long MOD = 1000000007L;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            adj.get(r[0]).add(new Pair(r[1], r[2]));
            adj.get(r[1]).add(new Pair(r[0], r[2]));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            int node = p.value;
            long cost = p.cost;

            if (cost > dist[node]) continue;

            for (int i = 0; i < adj.get(node).size(); i++) {

                int curr = adj.get(node).get(i).value;
                long c = adj.get(node).get(i).cost;

                if (cost + c == dist[curr]) {
                    ways[curr] = (ways[curr] + ways[node]) % MOD;
                }
                else if (cost + c < dist[curr]) {
                    dist[curr] = cost + c;
                    ways[curr] = ways[node];

                    pq.add(new Pair(curr, dist[curr]));
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}