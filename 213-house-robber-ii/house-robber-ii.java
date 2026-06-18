class Solution {
    int dp[] , dp2[];
    public int rob(int[] nums) {
        // do option either i choose the first or i choose the last 
        int n = nums.length;

        if(n == 1) return nums[0];

        dp = new int[n];

        dp2 = new int[n];

        Arrays.fill(dp , -1);

        Arrays.fill(dp2, -1);

        return  Math.max(helper(nums , 0) , helper1(nums  , 1));

    }
    public int helper(int[] nums , int idx){
        if(idx >= nums.length-1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + helper(nums , idx +2);

        int skip = helper(nums , idx +1);

        return dp[idx] = Math.max(pick , skip);
    }
    public int helper1(int[] nums , int idx){
        if(idx >= nums.length) return 0;

        if(dp2[idx] != -1) return dp2[idx];

        int pick = nums[idx] + helper1(nums , idx +2);

        int skip = helper1(nums , idx +1);

        return dp2[idx] = Math.max(pick , skip);
    }
}