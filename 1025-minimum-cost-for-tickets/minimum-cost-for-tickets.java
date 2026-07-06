class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int w1 = costs[0] + dp[lb(days, i + 1, n - 1, days[i] + 1)];
            int w2 = costs[1] + dp[lb(days, i + 1, n - 1, days[i] + 7)];
            int w3 = costs[2] + dp[lb(days, i + 1, n - 1, days[i] + 30)];

            dp[i] = Math.min(w1, Math.min(w2, w3));
        }

        return dp[0];
    }

    private int lb(int[] arr, int start, int end, int target) {
        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}