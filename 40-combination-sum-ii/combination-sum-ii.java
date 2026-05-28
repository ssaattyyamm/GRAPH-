class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        helper(arr, target , res , new ArrayList<>(),0);
        return res;
    }
    public void helper(int [] arr , int target ,List<List<Integer>> res ,List<Integer> ds , int idx){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i > idx && arr[i]== arr[i-1]) continue;

            ds.add(arr[i]);
            helper(arr, target - arr[i] , res, ds, i+1);
            ds.remove(ds.size() -1);
        }
    }
}