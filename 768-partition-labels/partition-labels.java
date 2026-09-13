class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            map.put(ch, i);
        }

        List<Integer> list = new ArrayList<>();

        int start = 0;
        int end = 0;

        for(int i = 0 ; i < n ;i++){
            end = Math.max(end , map.get(s.charAt(i)));

            if(i == end){
                list.add(end - start  + 1);
                start = end + 1;
            }
        }
        return list;
    }
}