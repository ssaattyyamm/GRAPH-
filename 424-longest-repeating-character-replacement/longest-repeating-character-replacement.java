class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int i = 0;
        int j = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        int max = 0;

        int ans = 0;

        while(j < n){
            char ch = s.charAt(j);
            map.put(ch , map.getOrDefault(ch , 0) + 1);
            max = Math.max(max , map.get(ch));

            if(((j - i + 1) - max) > k){
                char c  = s.charAt(i);
                map.put(c , map.get(c) - 1);

                if(map.get(c) == 0){
                    map.remove(c);
                }
                i++;
            }

            // map.put(ch , map.getOrDefault(ch , 0) + 1);
            ans = Math.max(ans , j - i + 1);
            // max = Math.max(max , map.get(ch));
            j++;
        }
        return ans;
    }
}