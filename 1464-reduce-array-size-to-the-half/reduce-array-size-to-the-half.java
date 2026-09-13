class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ;i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return map.get(b) - map.get(a);
        });

        for(int key : map.keySet()){
            pq.add(key);
        }

        int total = 0;

        int res = 0;

        while(pq.size() > 0 && total < n /2){
            int val = pq.poll();
            total += map.get(val);
            res ++;
        }

        return res;
    }
}