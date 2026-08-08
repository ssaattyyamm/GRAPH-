class Solution {
    int n , m ;
    int inf = (int) 1e9;
    public int calculateMinimumHP(int[][] arr) {
        n = arr.length;
        m = arr[0].length;

        int dp[][] = new int[n][m];

        // state dp[i][j] = min health req to reach i , j  to n - 1, m -1;
        // base case if last cell is neg then we need - ( arr[i][j]) + 1;
        // else 1

        if(arr[n-1][m-1] > 0){
            dp[n-1][m-1] = 1;
        }
        else dp[n-1][m-1] = -1 * (arr[n-1][m-1]) + 1;

        for(int i = n - 1 ; i >= 0 ;i--){
            for(int j = m - 1 ; j >= 0 ; j --){
                if(i == n - 1 && j == m -1) continue;
                else{
                    int right = inf;
                    int down = inf;

                    if(j + 1 <  m){
                        right = dp[i][j + 1];
                    }
                    if(i + 1 < n){
                        down = dp[i + 1][j];
                    }

                    dp[i][j] = Math.max(1 , -1 * arr[i][j] + Math.min(right , down));
                }
            }
        }

        return dp[0][0];
    }
    public int helper(int[][] arr , int i , int j ){
        if(i >= n || j >= m) return inf;

        if(i == n - 1 && j == m - 1){
            if(arr[i][j] > 0){
                return 1;
            }
            else return -1 * (arr[i][j]) + 1;
        }

        int right = helper(arr , i , j + 1);
        int down = helper(arr , i + 1 , j);

        return Math.max(1 , -1 * arr[i][j] + Math.min(right , down));
    }
}