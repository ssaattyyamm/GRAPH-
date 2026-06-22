class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        //[1,2,3] : what is the condn 

        int dp[] = new int[n];

        int hash[] = new int[n];

        int last = 0;
        int len = 0;

        dp[0] = 1;
        hash[0] = 0;

        for(int i=1;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0 && dp[i]  < dp[j] + 1){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(len < dp[i]){
                len = dp[i];
                last = i;
            }
        }

        // hh

        ArrayList<Integer> res = new ArrayList<>();

        while(hash[last] != last){
            res.add(nums[last]);
            last = hash[last];
        }

        res.add(nums[last]);

        Collections.reverse(res);

        return res; 
    }
}