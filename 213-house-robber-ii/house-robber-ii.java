class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        if(n  == 2) return Math.max(nums[0] , nums[1]);

        int dp[] = new int[n-1];

        int d[] = new int[n-1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        d[0] = nums[1];
        d[1] = Math.max(nums[1] , nums[2]);

        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }

        for(int i=3;i<n;i++){
            d[i-1] = Math.max(nums[i] + d[i-3] , d[i-2]);
        }

        return Math.max(dp[n-2] , d[n-2]);
    }
}