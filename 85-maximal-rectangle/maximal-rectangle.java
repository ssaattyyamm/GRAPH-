class Pair{
    int val;
    int idx;

    public Pair(int val , int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int maximalRectangle(char[][] matrix) {
        // this is the variation of mah:

        int n = matrix.length;

        int m = matrix[0].length;

        int arr[] = new int[m];

        int ans = Integer.MIN_VALUE;

        for(int j=0;j<m;j++){
            arr[j] = matrix[0][j] - '0';
        }

        ans = largestRectangleArea(arr);

        System.out.println(ans);

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1'){
                    arr[j]++;
                }
                else{
                    arr[j] = 0;
                }
            }
            ans = Math.max(ans , largestRectangleArea(arr));
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
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