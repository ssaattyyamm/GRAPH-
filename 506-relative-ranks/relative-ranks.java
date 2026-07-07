class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        HashMap<Integer,String> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : score){
            pq.add(x);
        }

        String ans[] = new String[n];

        int cnt = 1;

        while(pq.size() > 0){
            int val  = pq.poll();

            if(cnt == 1){
                map.put(val ,"Gold Medal");
                cnt++;
            }
            else if(cnt == 2){
                map.put(val ,"Silver Medal");
                cnt++;
            }
            else if(cnt == 3){
                map.put(val ,"Bronze Medal");
                cnt++;
            }
            else{
                map.put(val ,String.valueOf(cnt));
                cnt++;
            }
        }

        for(int i=0;i<n;i++){
            ans[i] = map.get(score[i]);
        }

        return ans;
    }
}