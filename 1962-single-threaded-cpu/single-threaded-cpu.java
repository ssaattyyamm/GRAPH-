class Pair{
    int val;
    int idx;

    public Pair(int val , int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int arr[][] = new int[n][3];

        for(int i =  0 ; i < n ;i++){
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x , y) ->{
            if(x.val == y.val) return Integer.compare(x.idx , y.idx);
            else return Integer.compare(x.val , y.val);
        });

        Arrays.sort(arr , (a,b) -> Integer.compare(a[0] , b[0]));

        int ans[] = new int[n];

        int k = 0;

        int time = arr[0][0];

        int i = 0;

        while(i < n || pq.size() > 0){
            while(i < n && arr[i][0] <= time){
                // System.out.println(tasks[i][0]);
                pq.add(new Pair(arr[i][1] , arr[i][2]));
                // time += tasks[i][0];
                i++;
            }

            if(pq.size() > 0){
               Pair p = pq.poll();

               time += p.val;
            //    System.out.println(val);

                ans[k++] = p.idx;
            }
            else{
                time = arr[i][0];
            }
            // System.out.println(time);
        }

        // while(pq.size() < 0)
        return ans;
       
       }

    }
