class Solution 
{
    public int nthMagicalNumber(int n, int a, int b) 
    {
        //if(b>a)return nthMagicalNumber(n,b,a);
        long A = (long)a;
        long B = (long)b;
        long mod = 1000000007;
        long LCM = A*B/HCF(A,B);
        //int comp = (a+b)-LCM;
        long low = Math.min(A,B); 
        long high = Math.min(A,B)*n;
        while(low<high)
        {
            long mid = low+(high-low)/2;
            long zaza = mid/a+mid/b-mid/LCM;
            if(zaza<n)
            {
                low = mid+1;
            }
            else if(zaza>n)
            {
                high = mid-1;
            }
            else
            {
                return (int)(Math.max((mid/a)*a,(mid/b)*b)%mod);
            }
        }
        return (int)(Math.max((low/a)*a,(low/b)*b)%mod);
    }
    public long HCF(long a, long b)
    {
        if(b>a)return HCF(b,a);
        if(a%b==0)return b;
        return HCF(b,a%b);
    }
}
