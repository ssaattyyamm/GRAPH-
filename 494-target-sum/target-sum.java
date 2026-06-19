class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int  n = nums.length;

        int sum =0;

        for(int i=0;i<n;i++){
            sum += nums[i];
        }

        int curr = (sum  + target)/2;

        if((sum + target )% 2 != 0 || (sum + target) < 0) return 0;

        int dp[][] = new int[n+1][curr+1];

        dp[0][0] = 1;

        for(int i =1 ;i<=n;i++){
            for(int j=0;j<=curr;j++){
                int pick = 0;

                if(j  >= nums[i-1]){
                    pick = dp[i-1][j - nums[i-1]];
                }
                dp[i][j] =pick + dp[i-1][j];
            }
        }

        return dp[n][curr];
    }
}