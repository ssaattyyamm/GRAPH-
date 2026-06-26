class Pair{
    int  value;
    int ops;

    public Pair(int value , int ops){
        this.value = value;
        this.ops = ops;
    }
}
class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(x < y ) return y - x;
        Queue<Pair> queue = new LinkedList<>();

        int visit[] = new int[1000000];

        Arrays.fill(visit , -1);

        visit[x] = 1;

        queue.add(new Pair(x , 0));

        while(queue.size() > 0){
            int value  = queue.peek().value;
            int ops = queue.peek().ops;

            if(value == y) return ops;

            queue.poll();

            if(value % 11 == 0){
                if(visit[value / 11] == -1){
                    visit[value /11] =1;
                    queue.add(new Pair(value / 11 , ops +1));
                }
            }
            if(value % 5 == 0){
                if(visit[value / 5] == -1){
                    visit[value /5] =1;
                    queue.add(new Pair(value / 5 , ops +1));
                }
            }

            if(visit[value + 1] == -1){
                visit[value  + 1] =1;
                queue.add(new Pair(value + 1 , ops +1));
            }
             if(value -1 > 0 && visit[value-1] == -1){
                visit[value-1] =1;
                queue.add(new Pair(value -1 , ops +1));
            }
        }

        return -1;
    }
}