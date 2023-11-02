//0ms
class Solution 
{
    public int integerBreak(int n) 
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return ib(n,dp);
    }
    public int ib(int n, int[] dp)
    {
        if(n==1)return 1;
        if(dp[n]!=-1)return dp[n];
        int max = 1;
        for(int i=1; i<n; i++)
        {
            int a = ib(n-i,dp);
            int b = Math.max(a*i,(n-i)*i);
            max = Math.max(max, b);
        } 
        return dp[n]=max;
    }
}
