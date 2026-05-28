class Solution {
    double pow(double x, int n) {
        if (n == 0){
            return 1;
        }
        double pb2 = pow(x, n / 2);
        double pow = pb2 * pb2;
        if (n % 2 != 0) {
            pow = pow * x;
        }
        return pow;
    }

    public double myPow(double x, int n) {
        double nn=n;
        if(nn<0){
            n=n*(-1);
        }
        double ans=pow(x,n);
        if(nn<0){
            ans=1/ans;
        }
        return ans;
    }
}