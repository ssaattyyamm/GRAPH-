class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int ans = 0;

        for(int x : arr){
            int len = map.getOrDefault(x - diff , 0) + 1;
            map.put(x , len);
            ans = Math.max(ans , len);
        }

        return ans;
    }
}