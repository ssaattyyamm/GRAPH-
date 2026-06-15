class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //thought process :  simple hoga 
        // mai kya kehrha hu jo bhi nodes hai unhe revese krdenga 
        // terminal node : indeg = 0;
        //un nodes ko queue k andar dal dunga 

        // we can use the concept of topological sort

        int v = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

       //adj list create 

       for(int i=0;i<v;i++){
        for(int j=0;j<graph[i].length;j++){
            adj.get(graph[i][j]).add(i);
        }
       }

       int indeg[] = new int[v];

       for(int i=0;i<v;i++){
        for(int x : adj.get(i)){
            indeg[x]++;
        }
       }

       Queue<Integer> q = new LinkedList<>();

       for(int i=0;i<v;i++){
        if(indeg[i] == 0) q.add(i);
       }

       ArrayList<Integer> res = new ArrayList<>();

       while(q.size() > 0){
        int curr = q.peek();
        res.add(curr);
        q.poll();

        for(int x : adj.get(curr)){
            indeg[x]--;

            if(indeg[x] == 0) q.add(x);
        }
       }

       Collections.sort(res);

       return res;
    }
}