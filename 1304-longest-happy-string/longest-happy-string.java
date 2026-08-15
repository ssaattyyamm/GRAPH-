class Pair{
    Character ch;
    int cnt;

    public Pair(Character ch , int cnt){
        this.ch = ch;
        this.cnt = cnt;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.cnt - x.cnt);

        if(a != 0) pq.add(new Pair('a' , a));
        if(b != 0) pq.add(new Pair('b' , b));
        if(c != 0) pq.add(new Pair('c' , c));

        String ans = "";

        while(pq.size() > 0){
            Pair p = pq.poll();

            char ch2 = p.ch;
            int cnt = p.cnt;

            int n = ans.length();

            if(n >= 2 && ans.charAt(n -1) == ans.charAt( n - 2) && ans.charAt(n -1 ) == ch2){  if(pq.size() == 0) break;
                Pair temp = pq.poll();

                char ch   =  temp.ch;
                int count = temp.cnt;

                ans += ch;

                if(count - 1 > 0){
                    pq.add(new Pair(ch , count -1));
                }
                if(cnt > 0){
                    pq.add(new Pair(ch2 , cnt));
                }
            }
            else{
                ans += ch2;
                if(cnt - 1 > 0){
                    pq.add(new Pair(ch2 , cnt -1));
                }
            }
        }

        return ans;
    }
}