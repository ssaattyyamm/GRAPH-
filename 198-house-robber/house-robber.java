class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        
        dp = new int[n+1];

        Arrays.fill(dp , -1);

        return helper(nums , -1, 0, n);
    }
    public int helper(int [] nums , int last , int idx , int n ){
        if(idx  >= n){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        // pick 
        int pick = nums[idx] + helper(nums , idx , idx +2 , n);

        //not pick
        int notpick = helper(nums , last , idx +1 , n);

        return dp[idx] =  Math.max(pick , notpick);
    }
}