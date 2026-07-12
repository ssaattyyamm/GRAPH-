class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String[] word = s.split("\\s+");

        int n = word.length ;

        StringBuilder sb = new StringBuilder();

        for(int i = n -1 ;i >= 0;i--){
            sb.append(word[i]);
            if(i > 0) sb.append(" ");
        }
        return sb.toString();
    }
}