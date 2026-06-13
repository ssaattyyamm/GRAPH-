class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();

        for(int i=0;i<words.length;i++){
            int curr =0;

            for(char ch : words[i].toCharArray()){
                curr += weights[ch -'a'];
            }

            int mod = curr % 26;

            char rev = (char) ('z' - mod);

            str.append(rev);
        }

        return str.toString();
    }
}