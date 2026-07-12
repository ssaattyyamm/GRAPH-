class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        if(n == 1) return true;

        int max = 0;

        for(int i = 0 ; i < n ;i++){
            max = Math.max(max , nums[i] + i);
            if(nums[i]  == 0 && max <= i && i != n -1) return false;
        }

        return max >= n-1;
    }
}