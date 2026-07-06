class Solution {
    HashMap<Integer, Integer> map;
    public long maximumTotalDamage(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0 ) + 1);
        }

        long dp[] = new long[n+1];

        dp[n] = 0;
        dp[n-1] = arr[n-1];

        for(int i=n-2;i>=0;i--){
            int l = lb(arr , i +1 , n-1 ,  arr[i] + 3);

            long pick = 1L * arr[i] * map.get(arr[i]) + dp[l];

            long skip = dp[i+1];

            dp[i] = Math.max(pick , skip);
        }

        return dp[0];
    }
    public int helper(int idx , int[] arr){
        if(idx == arr.length){
            return 0;
        }
        // if(idx == arr.length -1) return arr[idx];
        int l = lb(arr , idx +1 , arr.length -1 ,  arr[idx] + 3);

        int pick = (arr[idx] * map.get(arr[idx])) + helper(l , arr);

        int skip = helper(idx +1 , arr);

        return Math.max(pick , skip);
    }
    public int lb(int[] arr , int start  , int end , int target){
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] >= target){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
    }
}