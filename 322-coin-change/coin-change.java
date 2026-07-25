class Solution {
    int inf = (int)1e9;

    int dp[][];
    public int coinChange(int[] arr, int amount) {
        int n = arr.length;

        dp = new int[n+1][amount + 1];

        for(int i = 0 ; i <= n ; i ++){
            Arrays.fill(dp[i] , -1);
        }

        int ans =  helper(arr , amount , n);

        return ans == inf ? -1 : ans;
    }
    public int helper(int[] arr , int amount , int idx){
        if(amount == 0) return 0;

        if(idx == 0) return inf;

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int pick = inf;

        if(amount >= arr[idx -1]){
            pick =  1 + helper(arr , amount - arr[idx -1] , idx);
        }

        int skip = helper(arr ,amount , idx -1);

        return dp[idx][amount] = Math.min(pick , skip);
    }
}