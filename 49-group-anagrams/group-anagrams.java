class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        List<List<String>> list = new ArrayList<>();

        HashMap<String , List<String>> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            String curr = strs[i];
            char[] arr = curr.toCharArray();

            Arrays.sort(arr);

            String str = new String(arr);

            if(!map.containsKey(str)){
                map.put(str , new ArrayList<>());
            }

            map.get(str).add(curr);
        }

        return new ArrayList<>(map.values());
    }
}