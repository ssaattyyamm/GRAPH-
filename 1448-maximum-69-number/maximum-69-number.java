class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);

        String ans = "";

        boolean check = false;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '9'){
                ans += s.charAt(i);
            }
            else{
                if(check == false){
                    ans += '9';
                    check = true;
                }
                else{
                    ans += '6';
                }
            }
        }
        return Integer.parseInt(ans);
    }
}