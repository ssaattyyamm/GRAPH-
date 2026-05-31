class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int ones = 0;

        int ans = 0;

        int i=0;
        int j=0;

        while(j < n){
            if(nums[j] == 1){
                ones ++;
            }

            if((j-i+1) - ones > k){
                if(nums[i] == 1) ones--;
                i++;
            }
            ans = Math.max(ans , j-i+1);
            j++;
        }
        return ans;
    }
}