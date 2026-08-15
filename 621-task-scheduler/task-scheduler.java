class Solution {
    public int leastInterval(char[] tasks, int n) {
        // a to z
        //  a-3
        // b - 3
        //a - 2 b - 2 c 1d 1
        /// a b a bc d
        // a - 3 times and b - 3 times
        // a

        // how greedy works : basically greedy is  jiskii freq jyada hai 

        int len = tasks.length;

        int freq[] = new int[26];

        for(int i = 0 ; i <  len ; i++){
            char ch = tasks[i];

            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int  i = 0 ; i < 26 ;i++){
            if(freq[i] > 0){
                pq.add(freq[i]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        
        int ans = 0;

        while(pq.size() > 0 || queue.size() > 0){
            ans++;

            if(pq.size() > 0){
                int val = pq.poll() - 1;

                if(val > 0){
                    queue.add(new int[]{val,ans + n});
                }
            }

            if(queue.size() > 0 && queue.peek()[1] == ans){
                pq.add(queue.poll()[0]);
            }
        }
        return ans;
    }
}