class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        int i=0;
        int j=0;

        int ans =0;

        while(j < n){
            map.put(arr[j] , map.getOrDefault(arr[j] ,0)+ 1);

            while(map.size() > 2){
                map.put(arr[i] , map.get(arr[i]) -1);

                if(map.get(arr[i])== 0) map.remove(arr[i]);

                i++;
            }

            ans = Math.max(ans , j-i+1);
            j++;
        }

        return ans;
    }
}