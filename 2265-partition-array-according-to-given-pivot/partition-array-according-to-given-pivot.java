class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int k =0;
        int n =nums.length;
        int temp[] =new int[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(nums[i]< pivot){
               temp[k++]=nums[i];
            }
            if(nums[i]==pivot) count ++;
        }
        for(int i=0;i<count;i++){
            temp[k++]=pivot;
        }
        System.out.print(k);
        for(int i=0;i<n;i++){
            if(nums[i]>pivot) temp[k++]=nums[i];
        }

        // for(int i=0;i<n;i++){
        //     if(nums[i] >= pivot){
        //         int temp =nums [i];
        //         nums[i]=nums[k];
        //         nums[k]=temp;
        //         k++;
        //     }
        // }
        return temp;
    }
}