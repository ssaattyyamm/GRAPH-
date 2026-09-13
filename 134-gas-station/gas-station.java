class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int tgas = 0;
        int tcost = 0;

        for(int i = 0 ; i < n ; i++){
            tgas += gas[i];
            tcost += cost[i];
        }

        if(tgas < tcost) return -1;

        // gas station :

        int total = 0;
        int res = 0;

        for(int i = 0 ; i < n ; i++){
            total = total + gas[i] - cost[i];

            if(total < 0){
                res = i + 1;
                total = 0;
            }
        }

        return res;

    }
}