class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr , (a,b)->{
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });

        int maxend = arr[0][1];
        int cnt = 1;

        for(int i=1;i<arr.length;i++){
            if(arr[i][1] > maxend){
                maxend = arr[i][1];
                cnt++;
            }
        }

        return cnt;
    }
}