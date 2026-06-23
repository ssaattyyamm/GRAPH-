class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> res = new ArrayList<>();

        res.add(nums[0]);

        for(int i=1;i<n;i++){
            if(res.get(res.size() -1 ) < nums[i]){
                res.add(nums[i]);
            }
            else{
                int idx = lb(res ,nums[i]);

                if(idx != -1) res.set(idx , nums[i]);
            }
        }

        return res.size();
    }
    public int lb(ArrayList<Integer> res  , int target){
        int start  = 0;
        int end = res.size() -1;

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(res.get(mid) >= target){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }

        return ans;
    }
}