class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans=1;
        int n=nums.length;
        int a=nums[0];
        int b=nums[1];
        int c=nums[n-3];
        int d=nums[n-2];
        int e=nums[n-1];
        return Math.max(a*b*e,c*d*e);
        
    }
}
//[-14,-2,1,2,3]
//[-12,-11,-10,-9]