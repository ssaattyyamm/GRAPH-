class Solution {
    public boolean canPartition(int[] arr) {
        //
      int n = arr.length;

      int target = 0;

      for(int i=0;i<n;i++){
        target+=arr[i];
      }

      if(target  % 2 != 0) return false;

      target = target /2;

      boolean dp[][] = new boolean[n+1][target+1];

      for(int i=0;i<=n;i++){
        for(int j=0;j<=target;j++){
            if(i == 0) dp[i][j] = false;
            if(j == 0) dp[i][j] = true;
        }
      }

      for(int i=1;i<=n;i++){
        for(int j=1;j<=target;j++){
            boolean pick = false;
            if(j >= arr[i-1]){
                pick = dp[i-1][j - arr[i-1]];
            }

            dp[i][j] = pick || dp[i-1][j];
        }
      }

      return dp[n][target];
    }
}