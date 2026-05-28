class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n;

        int ans = low;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(mid == n-1){
                ans = mid;
                high = mid -1;
            }
            else if(arr[mid] > arr[mid +1]){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }

        return ans;
    }
}