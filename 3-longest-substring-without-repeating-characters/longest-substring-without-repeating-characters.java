class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int i=0;
        int j=0;

        HashMap<Character,Integer> map = new HashMap<>();

        int ans = 0;
        
        while(j < n){
            char ch = s.charAt(j);

            if(map.containsKey(ch) && i <= map.get(ch)){
                i = map.get(ch) +1;
            }
            ans = Math.max(ans , j-i+1);
            map.put(ch , j);
            j++;
        }
        return ans;
    }
}