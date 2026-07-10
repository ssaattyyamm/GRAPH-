class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // exaclty k 
        return atmost(nums , k) -  atmost(nums , k -1);
    }
    public int atmost(int[] nums , int k ){
        int i = 0 ;
        int j = 0;

        int n = nums.length;

        int ans = 0;

        HashMap<Integer ,Integer > map = new HashMap<>();

        while(j < n){
            map.put(nums[j] , map.getOrDefault(nums[j] , 0) + 1);

            while(map.size() > k){
                map.put(nums[i] , map.get(nums[i]) - 1);

                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;

                // 1  2 3 
            }
            ans += (j -i + 1);
            j++;
        }

        return ans;
    }
}