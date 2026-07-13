class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue  = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);

        while(queue.size() > 0){
            int val = queue.poll();
            int last = val % 10 ;
            int curr = val * 10 + last + 1;

            if(val >= low && val <= high) list.add(val);
            if(val > high) break;

            if(last < 9) queue.add(curr);
        }

        return list;
    }
}