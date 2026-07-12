class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        
        Arrays.sort(people);

        int i = 0;
        int j = n -1;

        int ans = 0;

        while(i <= j){
            if(people[i] + people[j] > limit){
                j--;
            }
            else{
                i++;
                j--;
            }
            ans++;
        }

        return ans;
    }
}