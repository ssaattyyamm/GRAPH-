class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words , (a,b)->a.length() - b.length());

        int n = words.length;

        int dp[] = new int[n];

        dp[0] = 1;

        int ans = 1;

        for(int i=1;i<n;i++){
            dp[i] = 1;
             System.out.println(words[i]);
            for(int j=0;j<i;j++){
                String a = words[j];
                String b = words[i];

                if(b.length() - a.length() == 1 && check(a,b) && dp[i] < dp[j] + 1){
                    dp[i] = dp[j]+1;
                }
            }
            ans = Math.max(ans , dp[i]);
        }

        return ans;
    }
    public boolean check(String a , String b){
        int cnt  = 0;

        //xb xcb
        
        int i=0;
        int j=0;

        while(i< a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else{
                if(cnt == 1) return false;
                else{
                    cnt++;
                    j++;
                }
            }
        }
        return true;
    }
}