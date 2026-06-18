class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;

        dp = new int[n];

        Arrays.fill(dp , -1);

        return helper(nums , 0);
    }
    public int helper(int[] nums , int idx ){
        if(idx >= nums.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + helper(nums , idx +2);

        int skip = helper(nums , idx +1);

        return dp[idx] =  Math.max(pick , skip);
    }
}