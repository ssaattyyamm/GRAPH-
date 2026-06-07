class Solution {
    public long maxTotal(int[] nums, String s) {
        //kya kr sakte hai :

        //"011110" :  agar kabhi bhi consecutive one milte hai [start - 1 , end]  jaisa given tc mai consecutive one start hua first idx pr , end hua 4 pr  , then res = sum of all element from start -1 to end - Math.min(start-1 to end)

        // jaisa hi zero hit hoga we subtract the min and update the minimum

        int n = nums.length;

        long res = 0;

        long min = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                //we can add this :
                res += nums[i];

                min = Math.min(min, nums[i]);

            } else {
                // agar kabhi bhi zero hit hota hai 
                if (i + 1 < n && s.charAt(i + 1) == '1') {
                    res += nums[i];

                    min = Math.min(min, nums[i]);

                    res -= min;
                }
                min = Integer.MAX_VALUE;
            }
        }
        return res;
    }
}