class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n + 1];

        // state ::  dp[i] = max amnt of money that can i earn 

        dp[n-1] = nums[n-1];

        for(int i = n-2 ; i >=0 ; i--){
            int pick = nums[i] + dp[i+2];

            int skip = dp[i + 1];

            dp[i] = Math.max(pick , skip);
        }

        return dp[0];

    }
    public int helper(int[] nums , int idx){
        if(idx >= nums.length) return 0;

        int pick = nums[idx] + helper(nums , idx + 2);

        int skip = helper(nums , idx + 1);

        return Math.max(pick , skip);

    }
}