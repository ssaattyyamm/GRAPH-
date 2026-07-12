class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0 ;i < arr.length;i++) {
            if (!map.containsKey(arr[i])){
                map.put(arr[i] , new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        int rank = 1;

        for(int key : map.keySet()){
            for(int j = 0;j < map.get(key).size();j++){
                 arr[map.get(key).get(j)] = rank;
            }
            rank++;
        }

        return arr;
    }
}