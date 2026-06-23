class Solution {
    public boolean canFinish(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int indeg[] = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        for(int e[] : edges){
            adj.get(e[1]).add(e[0]);
            indeg[e[0]]++;
        }

        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                queue.add(i);
            }
        }

        ArrayList<Integer> res =new ArrayList<>();

        while(queue.size() > 0){
            int node = queue.peek();
            res.add(node);

            queue.poll();

            for(int i= 0;i<adj.get(node).size();i++){
                int curr = adj.get(node).get(i);

                indeg[curr]--;

                if(indeg[curr] == 0) queue.add(curr);
            }
        }

        return res.size() == n;
    }
}