class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int k =  n - 1;

        while(j <= k){
            if(nums[j] == 0){
                swap(nums , j , i);
                i++;
                j++;
            }
            else if(nums[j] == 1){
                j++;
            }
            else{
                swap(nums , j , k);
                k--;
            }
        }
    }
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}