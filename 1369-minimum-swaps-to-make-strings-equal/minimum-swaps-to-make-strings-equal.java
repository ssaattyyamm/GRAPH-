class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();

        // xy xy 
        // yx yx

        int xy = 0;
        int yx = 0;

        for(int i = 0 ; i < n ; i++){
            char  a = s1.charAt(i);
            char b = s2.charAt(i);

            if(a == b) continue;

            if(a == 'x' && b == 'y') xy++;
            else yx++;
        }

        if((xy + yx) % 2 != 0) return -1;

        int ans = xy /2 + yx /2;

        if(xy % 2 != 0){
            ans += 2;
        }

        return ans;
    }
}