class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int prime[] = { 2 , 3, 5};

        HashSet<Long>  set = new HashSet<>();

        pq.add(1l);

        long curr = 1;

        for(int i = 0 ; i < n ;i++){
            curr = pq.poll();

            for(int j = 0 ; j < 3 ;j++){
                if(set.add(curr * prime[j])){
                    pq.add(curr * prime[j]);
                }
            }
        }

        return (int) curr;

    }
}