// 
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        
        int arr[][] = new int[n][3];

        for(int i = 0 ; i < n ; i ++){
            arr[i][0] = costs[i][0];
            arr[i][1] = costs[i][1];
            arr[i][2] = costs[i][0] - costs[i][1];
        }

        Arrays.sort(arr , (a,b) -> Integer.compare(a[2] , b[2]));


        int ans = 0;

        int cnt = 0;

        for(int i = 0 ; i < n ;i++){
            if(cnt < n /2){
                ans += arr[i][0];
            }
            else{
                ans += arr[i][1];
            }
            cnt++;
        }

        return ans;
    }
}