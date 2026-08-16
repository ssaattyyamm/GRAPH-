class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i ++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int key : map.keySet()){
            list.add(map.get(key));
        }

        Collections.sort(list);

        // 1  2 3
        // 0
        int cnt = 0;

        for(int i = 0 ; i < list.size() ; i++){
            if(k < list.get(i)){
                break;
            }
            else{
                k -= list.get(i);
                cnt ++;
            }
        }

        return list.size() - cnt;
    }
}