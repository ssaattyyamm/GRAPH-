class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        helper(nums , res, 0);

        return res;
    }
    public void helper(int[] nums , List<List<Integer>> res  ,int idx){
       if(idx == nums.length){
         List<Integer> temp = new ArrayList<>();

         for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
         }
         res.add(temp);
         return;
       }

       for(int i=idx ;i<nums.length;i++){
         swaps(nums , idx , i);

         helper(nums , res, idx+1);

         swaps(nums , i , idx);
       }
    }
    public void swaps(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}