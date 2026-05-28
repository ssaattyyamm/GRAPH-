class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n=nums.length;
      int presum=1;
      int ans[]=new int[n];
      ans[0]=1;
      for(int i=1;i<n;i++){
        presum=presum*nums[i-1];
        ans[i]=presum;
      }
      int postsum=1;
      for(int i=n-1;i>=0;i--){
        ans[i]=ans[i]*postsum;
        postsum=postsum*nums[i];
      }
      return ans;
    }
}