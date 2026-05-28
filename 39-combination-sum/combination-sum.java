class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>>  res =  new ArrayList<>();
        helper(arr, target , new ArrayList<Integer>() , res, 0);

        return res;
    }
    public void helper(int[] arr , int target , List<Integer> ds , List<List<Integer>> res , int idx){
        if(idx == arr.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
                return;
            }
            return;
        }

        if(target >= arr[idx]){
            ds.add(arr[idx]);
            helper(arr , target - arr[idx] , ds ,res , idx);
            ds.remove(ds.size()-1);
        }

        helper(arr , target , ds , res, idx +1);
    }
}