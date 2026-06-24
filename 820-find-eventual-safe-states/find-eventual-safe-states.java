class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>>  adj = new ArrayList<>();

        int indeg[] = new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                indeg[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                queue.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(queue.size() > 0){
            int node = queue.peek();

            queue.poll();

            res.add(node);

            for(int i=0;i<adj.get(node).size();i++){
                int curr = adj.get(node).get(i);

                indeg[curr]--;

                if(indeg[curr] == 0){
                    queue.add(curr);
                }
            }
        }

        Collections.sort(res);

        return res;
    }
}