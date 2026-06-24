class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;

        int low = 0;

        int high = 0;

        int ans =0;

        for(int i=0;i<n;i++){
            high = Math.max(high , nums[i]);
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(check(nums , mid) == 1){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
    public int check(int[] nums , int mid){
        long carry =0;

        for(int i=nums.length-1;i>0;i--){
            long curr = nums[i] + carry;

            if(curr > mid){
                carry += nums[i] - mid;
            }
            else{
                carry =0;
            }
        }

        if(carry + nums[0] <= mid) return 1;
        else return 0;
    }
}