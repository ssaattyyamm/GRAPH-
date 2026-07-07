class Pair{
    Character ch;
    int count;

    public Pair(Character ch , int count){
        this.ch = ch;
        this.count = count;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.count - x.count);

        if(a != 0) pq.add(new Pair('a' , a));
        if(b != 0) pq.add(new Pair('b' , b));
        if(c != 0) pq.add(new Pair('c' , c));

        String ans = "";

        while(pq.size() > 0){
            Pair p = pq.poll();
            char ch2 = p.ch;
            int cnt = p.count;

            if(ans.length() >= 2 && ans.charAt(ans.length() -1) == ans.charAt(ans.length() - 2) && ans.charAt(ans.length() -1) == ch2){
                if(pq.size()  == 0) break;

                Pair temp = pq.poll();
                char ch = temp.ch;
                int count = temp.count;

                ans += ch;
                count--;

                if(count > 0) pq.add(new Pair(ch , count));
                if(cnt > 0) pq.add(new Pair(ch2 , cnt));
            }
            else{
                ans += ch2;
                cnt--;

                if(cnt > 0) pq.add(new Pair(ch2 , cnt));
            }
        }

        return ans;
    }
}