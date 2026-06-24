class Solution {
    public String processStr(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);

            if(Character.isLowerCase(c)){
                sb.append(c);
            }

            if(c == '#'){
                sb.append(sb);
            }
            if(c == '%'){
              sb.reverse();
            }
            if(sb.length() > 0 && c == '*'){
                sb.deleteCharAt(sb.length() - 1 );
            }
        }
        return sb.toString();
    }
    // public void rev(StringBuilder sb){
    //     sb.reverse().toString();
    // }
}