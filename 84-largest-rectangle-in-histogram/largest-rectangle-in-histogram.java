class Pair{
    int val;
    int idx;

    public Pair(int val , int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        // after a long time im solving this 
        // in this q we are findign the nsl and nsr 

        // [2,1,5,6,2,3]
        // nsl : []
        // nsr : []

        int n = heights.length;

        int res = Integer.MIN_VALUE;

        ArrayList<Integer> NSR = nsr(heights);

        ArrayList<Integer> NSL = nsl(heights);


        for(int i=0;i<n;i++){
            int width = NSR.get(i) - NSL.get(i) -1;

            res = Math.max(res , width * heights[i]);
        }

        return res;
    }
    public ArrayList<Integer> nsr(int [] arr){
        Stack<Pair> st = new Stack<>();

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=arr.length-1;i>=0;i--){
            while(st.size() > 0 && st.peek().val >= arr[i]){
                st.pop();
            }

            if(st.size() == 0) res.add(arr.length);
            else res.add(st.peek().idx);

            st.push(new Pair(arr[i] , i));
        }

        Collections.reverse(res);

        return res;
    }
    public  ArrayList<Integer> nsl(int [] arr){
        Stack<Pair> st = new Stack<>();

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            while(st.size() > 0 && st.peek().val >= arr[i]){
                st.pop();
            }

            if(st.size() == 0) res.add(-1);
            else res.add(st.peek().idx);

            st.push(new Pair(arr[i] , i));
        }

        // Collections.reverse(res);

        return res;
    }
}