class Solution {
    int inf = (int) 1e9;

    public int jump(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];

        dp[n - 1] = 0;

        for (int i = n-2; i >=0; i--) {
            int ans = inf / 2;

            for (int j = i + 1 ; j <= Math.min(i + nums[i], n - 1); j++) {
                ans = Math.min(ans, 1 + dp[j]);
            }

            dp[i] = ans;
        }

        return dp[0];
    }

    public int helper(int[] nums, int idx) {
        if (idx == nums.length - 1)
            return 0;

        // if(nums[idx] == 0) return inf;

        int ans = inf / 2;

        for (int i = idx + 1; i <= Math.min(idx + nums[idx], nums.length - 1); i++) {
            ans = Math.min(ans, 1 + helper(nums, i));
        }

        return ans;
    }
}