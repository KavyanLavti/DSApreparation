class Solution 
{
    public int climbStairs(int n) 
    {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // public int fox(int n, int[] dp)
    // {
    //     if(n<0)return 0;
    //     if(n==1||n==0)return 1;
    //     if(dp[n]!=-1)return dp[n];
    //     int X = fox(n-1,dp);
    //     int Y = fox(n-2,dp);
    //     return dp[n] = X+Y;
    // }
}
