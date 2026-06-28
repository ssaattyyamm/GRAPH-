class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //not hard problem : 
        //[1,1,2,2,2]
        //[1,2, 3]
        //simple se intuitonn : [1,7]
        // [ 1 , 1 ,2 ]
        int n = arr.length;

        if(n == 1) return 1;

        Arrays.sort(arr);
        arr[0] = 1;
        for(int i=0;i<n-1;i++){
            int val = Math.abs(arr[i] - arr[i+1]);

            if(val > 1){
              arr[i+1] = arr[i]+1;
            }
        }
        return arr[n-1]; 
    }
}