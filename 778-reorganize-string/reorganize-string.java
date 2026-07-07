class Pair{
    Character ch;
    int cnt;

    public Pair(Character ch , int cnt){
        this.ch = ch;
        this.cnt = cnt;
    }
}
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(Character ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.cnt  - a.cnt);

        for(Character ch : map.keySet()){
            pq.add(new Pair(ch , map.get(ch)));
        }

        String ans = "";

        while(pq.size() > 0){
            Pair p = pq.poll();
            char c = p.ch;
            int cnt = p.cnt;

            int n = ans.length();

            if(n > 0 && ans.charAt(n-1) == c){
                if(pq.size() == 0) break;

                Pair temp = pq.poll();
                char ch =  temp.ch;
                int count =  temp.cnt;

                ans += ch;
                count--;

                if(count != 0) pq.add(new Pair(ch , count));
                if(cnt != 0) pq.add(new Pair(c , cnt));
            }
            else{
                ans += c;
                cnt--;
                if(cnt != 0) pq.add(new Pair(c , cnt));
            }
        }

        if(ans.length() != s.length()) return "";
        else return ans;
    }
}