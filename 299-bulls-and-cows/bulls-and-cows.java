class Solution {
    public String getHint(String s, String g) {
        int cows =0;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int n = s.length();

        for(int i =0;i<n;i++){
            if(s.charAt(i)==g.charAt(i)) cows++;
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(g.charAt(i),map2.getOrDefault(g.charAt(i),0)+1);
        }
        int bulls = 0;
        for(Character keys : map1.keySet()){
            if(map2.containsKey(keys)){
                bulls+=Math.min(map1.get(keys),map2.get(keys));
            }
        }
        int count = bulls - cows;
      
        String result = cows + "" + 'A' + count + 'B';

        return result;
    }
}