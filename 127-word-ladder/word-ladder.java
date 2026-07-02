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
        ///target 5 min 
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(beginWord , 1));

        Set<String> set = new HashSet<>();

        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }

        while(queue.size() > 0){
            String curr = queue.peek().word;
            int step = queue.peek().steps;

            if(endWord.equals(curr)) return step;

            queue.poll();

            char arr[] = curr.toCharArray();

            for(int i=0;i<arr.length;i++){
                char original = arr[i];
                for(char ch = 'a' ; ch <='z';ch++){
                    arr[i] = ch;
                    String s = new String(arr);

                    if(set.contains(s)){
                        queue.add(new Pair(s , step + 1));
                        set.remove(s);
                    }
                }
                arr[i] = original;
            }
        }

        return 0;
    }
}