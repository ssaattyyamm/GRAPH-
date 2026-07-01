class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //[1,2,2,3] limit = 3

        //minimum no of boats ki req
        Arrays.sort(people);

        int n = people.length;

        int l =0;
        int r = n-1;

        int cnt = 0;

        // 1 2 2 3 

        while(l < r){
            int p1 = people[l];

            int p2 = people[r];

            if(p1 + p2 > limit){
                cnt++;
                r--;
            }
            else{
                l++;
                r--;
                cnt++;
            }
        }
        //1 2 2 3  limit = 3
        if(r - l == 0) cnt++;
        else if(l < r) cnt+=(r-l-1);

        return cnt;
    }
}