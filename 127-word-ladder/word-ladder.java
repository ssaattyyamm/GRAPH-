class Pair{
    String word;
    int steps;

    public Pair(String word , int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();

        for(String w : wordList){
            set.add(w);
        }

        // set 0(1)

        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(beginWord , 1));

        while(queue.size() > 0){
            String w = queue.peek().word;
            int step = queue.peek().steps;

            if(endWord.equals(w)) return step;
 
            queue.poll();

            char arr[] = w.toCharArray();

            for(int i=0;i<arr.length;i++){
                char original = arr[i];

                for(char ch = 'a' ; ch<='z' ;ch++){
                    arr[i] = ch;

                    String curr = new String(arr);

                    if(set.contains(curr)){
                        queue.add(new Pair(curr ,step +1));
                        set.remove(curr);
                    }
                }
                arr[i] = original;
            }
        }

        return 0;
    }
}