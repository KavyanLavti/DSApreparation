class Solution 
{
    public long mod = (long)Math.pow(10,9)+7;
    public int numRollsToTarget(int n, int k, int target) 
    {
        long[][] dp = new long[n+1][target+1];
        for(long[] rw:dp)Arrays.fill(rw,-1);
        return (int)sum(n,k,target,dp);
    }
    public long sum(int n, int k, int tr, long[][] dp)
    {
        if(tr==0 && n==0)return 1;

        if(n>tr||n*k<tr)return 0;
        //ADDING THIS CONDITION RATHER THAN ID(N<=0||TR<=0) GREATLY IMRPVES THE EFFICIENCY
        //AS N*1 <= TR AND N*K SHOULD ALWAYS BE >=TR

        if(dp[n][tr]!=-1)return dp[n][tr];
        long ans = 0;
        for(int i=1; i<=k; i++)
        {
            ans += sum(n-1,k,tr-i,dp)%mod;
            ans = ans%mod;
        }
        return dp[n][tr]=ans;
    }
}
