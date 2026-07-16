class Solution {
    public int[] findOrder(int V , int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V;i++){
            adj.add(new ArrayList<>());
        }

        int indeg[] = new int[V];

        for(int e[] :arr){
            adj.get(e[1]).add(e[0]);
            indeg[e[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int res[] = new int[V];
        int k = 0;

        for(int i = 0 ; i < V;i++){
            if(indeg[i] == 0){
                queue.add(i);
            }
        }

        while(queue.size() > 0){
            int node = queue.poll();
            res[k++] = node;

            for(int i = 0 ; i < adj.get(node).size();i++){
                int next = adj.get(node).get(i);
                indeg[next]--;

                if(indeg[next] == 0) queue.add(next);
            }
        }

        if(k == V) return res;

        else return new int[0];
    }
}