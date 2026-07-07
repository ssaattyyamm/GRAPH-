class Tuple{
    int total;
    int pass;
    double gain;

    public Tuple(int pass , int total){
        this.total = total;
        this.pass = pass;
        this.gain = (double)(pass + 1)/(total + 1) - (double) pass / total;
    }

}
class Solution {
    public double maxAverageRatio(int[][] classes, int extra) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) ->  Double.compare(b.gain , a.gain));

        for(int c[] : classes){
            pq.add(new Tuple(c[0] , c[1]));
        }

        while(extra > 0){
            Tuple temp = pq.poll();
            int total = temp.total;
            int pass = temp.pass;

            pq.add(new Tuple(pass +1 , total + 1));

            extra--;
        }

        double ans = 0;

        while(pq.size() > 0){
            Tuple temp = pq.poll();
            int total = temp.total;
            int pass = temp.pass;

            ans += (double) pass / total;
        }

        return ans / classes.length;
    }
}