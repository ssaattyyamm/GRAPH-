class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;

        int i=0;

        int j =0;

        int prod = 1;

        int ans= 0;

        while(j < n){
            prod *= nums[j];

            while(prod >= k && i <= j ){
                System.out.println(prod);
                prod /=nums[i];
                i++;
            }
            if(prod < k) ans += j-i+1;
            j++;
        }

        return ans;
    }
}