class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> res = new ArrayList<>();

         helper(n , "" , 0,0,res);

         return res;

    }
    public void helper(int n , String str  , int open , int close , List<String> res ){
        if(str.length()  == n *2){
            res.add(str);
        }

        if(str.length() > n * 2) return;

        if(open < n){
            helper(n , str + "(" , open + 1 , close ,res);
        }

        if(close < open){
            helper(n , str + ")" , open , close +1 , res);
        }
    }
}