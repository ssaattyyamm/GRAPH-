class  Pair{
    String word;
    int len;

    public Pair(String word , int len){
        this.word = word;
        this.len = len;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>();

        for(int i = 0 ; i < wordList.size();i++){
            set.add(wordList.get(i));
        }

        Queue<Pair> queue = new  LinkedList<>();
        queue.add(new Pair(beginWord , 1));

        while(queue.size() > 0){
            Pair p = queue.poll();
            String curr = p.word;
            int len = p.len;

            if(curr.equals(endWord)) return len;

            char[] arr = curr.toCharArray();
            for(int i = 0 ; i < arr.length;i++){
                char original = arr[i];

                for(char ch = 'a' ; ch <= 'z';ch++){
                    arr[i] = ch;
                    String s = new String(arr);

                    if(set.contains(s)){
                        set.remove(s);
                        queue.add(new Pair(s , len + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}