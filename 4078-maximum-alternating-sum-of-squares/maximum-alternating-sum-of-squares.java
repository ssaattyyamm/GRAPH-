class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]*=-1;
            }
        }
        Arrays.sort(nums);
        int odd=n/2;
        long negsum=0;
        for(int i=0;i<odd;i++){
            negsum=negsum+(nums[i]*nums[i]);
        }
        long possum=0;
        for(int i=odd;i<n;i++){
            possum=possum+(nums[i]*nums[i]);
        }
        return possum-negsum;
        //-1,-2,-3,1,2,3
    }
}