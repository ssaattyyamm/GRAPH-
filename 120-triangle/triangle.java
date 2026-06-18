class Solution {
    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new Integer[n][n];

        return helper(0, 0, triangle);
    }

    public int helper(int row, int col, List<List<Integer>> triangle) {

        if(row == triangle.size() - 1)
            return triangle.get(row).get(col);

        if(dp[row][col] != null)
            return dp[row][col];

        int down = helper(row + 1, col, triangle);
        int diagonal = helper(row + 1, col + 1, triangle);

        return dp[row][col] =
                triangle.get(row).get(col) + Math.min(down, diagonal);
    }
}