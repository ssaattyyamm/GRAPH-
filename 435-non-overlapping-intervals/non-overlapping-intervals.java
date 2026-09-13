class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr , (a ,b )->{
            return Integer.compare(a[1] , b[1]);
        });

        int cnt = 1;
        int end = arr[0][1];

        for(int i = 1 ; i < n ; i++){
            if(arr[i][0] >= end){
                cnt++;
                end = arr[i][1];
            }
        }

        return n - cnt;
    }
}