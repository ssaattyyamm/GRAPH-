class Solution {
    Boolean dp[][][];
    public boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length();
        int m = s2.length();
        int p = s3.length();

        dp = new Boolean[n+1][m+1][p+1];


        return helper(s1 , s2 ,s3 , 0 ,0 , 0);
    }
    public boolean helper(String s1 , String s2 , String s3 , int i , int j , int k){
        if(k == s3.length()) return (i == s1.length() && j == s2.length());

        if(dp[i][j][k] != null) return dp[i][j][k];

        boolean froms1 = false;
        boolean froms2 = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) froms1 = helper(s1 , s2 ,s3 , i + 1, j , k +1);

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k))  froms2 =  helper(s1, s2 ,s3 ,i , j + 1 , k +1);


        return dp[i][j][k] = froms1 || froms2;

    }
}