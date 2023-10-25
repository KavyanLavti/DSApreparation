class Solution 
{
    public int tribonacci(int n) 
    {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return fuck(n,dp);
        int[] dp = new int[n+1]; 
        for(int i=0; i<n+1; i++)
        {   
            if(i==0)
            {
                dp[i]=0;
            }
            else if(i<3)
            {
                dp[i]=1;
            }
            else
            {
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }
    // public int fuck(int n, int[] dp)
    // {
    //     if(n==0)return 0;
    //     if(n==1||n==2)return 1;
    //     if(dp[n]!=-1)return dp[n];
    //     return dp[n] = fuck(n-1,dp)+fuck(n-2,dp)+fuck(n-3,dp);
    // }
}
