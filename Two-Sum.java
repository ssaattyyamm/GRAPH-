1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        for (int i = 0; i < nums.length; i++) {
4            for (int j = i + 1; j < nums.length; j++) {
5                if (nums[j] == target - nums[i]) {
6                    return new int[] { i, j };
7                }
8            }
9        }
10        // If no valid pair is found, return an empty array instead of null
11        return new int[] {};
12    }
13}