class Pair{
    long val;
    int idx;

    public Pair(long val  , int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;

        boolean mark[] = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            if(a.val == b.val) return a.idx - b.idx;
            else return Long.compare(a.val , b.val);
        });

        long ans  = 0;

        for(int i=0;i<n;i++){
            pq.add(new Pair((long) nums[i] , i));
        }

        while(pq.size() > 0){
            Pair temp = pq.poll();
            long val = temp.val;
            int idx = temp.idx;

            if(mark[idx] == false){
                ans += val;
                
                mark[idx] = true;

                if(n > 1){
                    
                if(idx == 0){
                    mark[idx +1] = true;
                }
                else if(idx == n-1){
                    mark[idx -1] = true;
                }
                else{
                    mark[idx + 1] = true;
                    mark[idx -1] = true;
                }
                }
            }
        }

        return ans;
    }
}