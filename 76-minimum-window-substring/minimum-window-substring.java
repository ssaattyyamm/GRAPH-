class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        HashMap<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i < m;i++){
            char ch = t.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0)  +1);
        }

        int i = 0;
        int j = 0;
        
        int start = 0;

        int count = map.size();
        int res = Integer.MAX_VALUE;

        while(j < n){
            char ch = s.charAt(j);

            if(map.containsKey(ch)){
                map.put(ch , map.get(ch) - 1);

                if(map.get(ch) == 0){
                    count--;
                }
            }
            while(count == 0 && i <= j){
                if(res > (j - i + 1)){
                    res = j - i + 1;
                    // System.out.println(res);
                    start = i;
                }
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c , map.get(c)  + 1);
                    if(map.get(c) == 1) count++;
                }
                // if(map.get(c) == 1) count++;
                i++;
            }
            j++;
        }

        if(res == Integer.MAX_VALUE) return "";

        

        return s.substring(start , start + res);
    }
}