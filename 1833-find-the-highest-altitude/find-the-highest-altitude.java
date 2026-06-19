class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

        int ans = 0;

        int sum =0;

        for(int i=0;i<gain.length;i++){
            ans = Math.max(ans , sum += gain[i]);
        }

        return ans;
    }
}