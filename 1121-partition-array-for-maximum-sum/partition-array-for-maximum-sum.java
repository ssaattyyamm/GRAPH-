class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int dp[] = new int[n + 1];

        dp[n] = 0;

        for (int i = n -1; i >= 0; i--) {
            int ans = Integer.MIN_VALUE;

            int max = arr[i];

            for (int j = i; j < Math.min(i + k, arr.length); j++) {
                max = Math.max(max, arr[j]);

                ans = Math.max(ans, (max * (j - i + 1) + dp[j+1]));
            }

            dp[i] =  ans;

            System.out.println(dp[i]);
        }

        return dp[0];
    }

    public int helper(int[] arr, int idx, int k) {
        if (idx == arr.length)
            return 0;

        int ans = Integer.MIN_VALUE;

        int max = arr[idx];

        for (int i = idx; i < Math.min(idx + k, arr.length); i++) {
            max = Math.max(max, arr[i]);

            ans = Math.max(ans, (max * (i - idx + 1) + helper(arr, i + 1, k)));
        }

        return ans;
    }
}