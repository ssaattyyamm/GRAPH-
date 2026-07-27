class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        // 2 3 4 5 

        int a = nums[0] - 1;
        int b = nums[1] - 1;

        int c = nums[n-1] - 1;
        int d = nums[n-2] -1;

        return Math.max(a*b , c * d);
    }
}