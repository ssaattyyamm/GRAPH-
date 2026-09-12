class Solution {
    int dp[];
    public int jump(int[] nums) {
        int n = nums.length;

        dp = new int[n];

        Arrays.fill(dp , -1);

        return helper(nums , 0);
    }
    public int helper(int[] nums , int idx){
        if(idx >= nums.length -1){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        if(nums[idx] == 0) return Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;

        for(int i = 1 ; i <= nums[idx] ; i++){
            int next = helper(nums , idx + i);

            if(next != Integer.MAX_VALUE){
                ans = Math.min(ans , next + 1);
            }

            // ans = Math.min(ans , curr);
        }

        return dp[idx] = ans;
    }
}