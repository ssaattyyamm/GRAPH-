class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr , (a,b)-> Integer.compare(a[1] , b[1]));

        int start = arr[0][0];
        int end = arr[0][1];

        int ans = 0;

        /// 1 2 1 3 2 3 3 4

        for(int i = 1 ; i < n ; i++){
            if(arr[i][0] < end){
                ans ++;
            }
            else{
                end = arr[i][1];
            }
        }

        return ans;
    }
}