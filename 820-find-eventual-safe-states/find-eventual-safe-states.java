class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n;i++){
            adj.add(new ArrayList());
        }

        int indeg[] = new int[n];

        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                indeg[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < n;i++){
            if(indeg[i] == 0){
                queue.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(queue.size() > 0){
            int curr = queue.poll();
            ans.add(curr);

            for(int i = 0 ;i < adj.get(curr).size();i++){
                int next = adj.get(curr).get(i);
                indeg[next]--;

                if(indeg[next] == 0){
                    queue.add(next);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }
}