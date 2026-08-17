class Solution {
    public int halveArray(int[] nums) {
        int n = nums.length;

        double sum = 0;

        // 3 8 5 31 16.5

        double curr = 0;

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < n ; i ++){
            sum += nums[i];
            pq.add((double)nums[i]);
        }                                                                                                                                                                                                           

        int ops = 0;

         while(curr < sum /2){
            double val = pq.poll();

            System.out.println(curr);

            curr += val /2;

            pq.add(val / 2);
            ops++;
        }

        return ops;
    }
}