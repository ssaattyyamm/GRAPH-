class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];

        int sum =0;
        for(int i=0;i<n;i++){
            diff[i] = gas[i] -cost[i];
            sum+=diff[i];
        }

        if(sum < 0) return -1; // hence it is poossible to calucalte tha ns

        int ans =0;

        int max =Integer.MIN_VALUE;
        int suff =0;
        for(int i=n-1;i>=0;i--){
            suff+=diff[i];
            if(suff > max){
                max = suff;
                ans = i;
            }
        }
        return ans;
    }
}