class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts) {
        int len =  cuts.length + 2;

        dp = new int[len][len];

        for(int d[] : dp){
            Arrays.fill(d ,-1);
        }

        Arrays.sort(cuts);

        int arr[] = new int[len];

        arr[0] = 0;
        arr[len -1] = n;

        //[0,1 ,3, 4, 5,7]

        for(int i=1;i<len-1;i++){
            arr[i] = cuts[i-1];
        }

        return helper(1,len-2,arr);

    }
    public int helper(int i , int j , int[] arr){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = (int) 1e9;

        for(int k = i;k<=j;k++){
            int cost = (arr[j +1] - arr[i-1]) + helper(i , k-1 , arr) + helper(k +1 , j , arr);

            min = Math.min(min , cost);
        }

        return dp[i][j] =  min;
    }
}