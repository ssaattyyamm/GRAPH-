class Solution {
    public int rob(int[] nums) {
        // this is the very simple problem 
        int n = nums.length;

        if(n == 1) return nums[0];

        int dp[] = new int[n];

        dp[0] = nums[0];

        dp[1] = Math.max(nums[0] , nums[1]);

        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }

        return dp[n-1];
    }
    public int helper(int idx  , int[] nums ){
        if(idx  >= nums.length) return 0;

        return Math.max(nums[idx] + helper(idx + 2 , nums) , helper(idx + 1 , nums));
    }
}