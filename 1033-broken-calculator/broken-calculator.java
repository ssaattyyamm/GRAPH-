class Solution {
    public int brokenCalc(int startValue, int target) {
        // target = x 
        // for each ops

        /// we have startValue , target
        /// for each ops : start * 2  , start -1

        // result min ops that i need 

        // approach is reverse greedy

        int ans = 0;

        if(startValue >=  target) return startValue - target; // for input liike 1000 1

        while(target > startValue){
            if(target % 2 == 0){
                target /= 2;
            }
            else{
                target ++;
            }
            ans++;
        }

        // 2 15
        // 16 8 4 2
        return ans + (startValue - target);
    }
}