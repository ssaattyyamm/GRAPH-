class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        /// easy prblm anyone can do this : 

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int e[] : prerequisites){
            adj.get(e[0]).add(e[1]);
        }

        int indeg[] = new int[V];

        for(int i=0;i<V;i++){
            for(int x : adj.get(i)){
                indeg[x]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indeg[i] == 0) queue.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(queue.size() > 0){
            int curr = queue.peek();

            queue.poll();

            res.add(curr);

            for(int x : adj.get(curr)){
                indeg[x]--;
                if(indeg[x] == 0) queue.add(x);
            }
        }
        return res.size() == V;
    }
}