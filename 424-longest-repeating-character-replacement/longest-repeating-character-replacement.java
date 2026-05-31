class Solution {
    public int characterReplacement(String s, int k) {
        // just find the shrinking condn :
        // total replacable character : k
        // total char = j - i + 1
        // distnict char = toal - max_freq 


        // shrinking condn : dist char > k 

        int n = s.length();

        int i = 0;
        int j = 0;

        int max = 0;

        int res = 0;

        HashMap<Character,Integer>  map = new HashMap<>();

        while(j < n){
            char ch = s.charAt(j);

            map.put(ch,map.getOrDefault(ch,0)+1);

            max = Math.max(max , map.get(ch));

            if((j-i+1) - max > k){
                char c = s.charAt(i);
                
                map.put(c, map.get(c) - 1);

                if(map.get(c) == 0){
                    map.remove(c);
                }

                i++;
            }
            res = Math.max(res, j-i+1);
            j++;
        }
        return res;
    }
}