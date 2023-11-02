class Solution 
{
    public int numSquares(int n) 
    {
        // int m = (int)Math.sqrt(n);
        // int[] arr = new int[m];
        // for(int i=0; i<m; i++)
        // {
        //     arr[i] = (i+1)*(i+1);
        // }
        // int[] dp =new int[n+1];
        // Arrays.fill(dp,-1);
        // return nato(arr,n,dp);

        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1; i<=n; i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++)
            {
                min = Math.min(dp[i-j*j]+1,min);
            }
            dp[i] = min;
        }
        return dp[n]; 
    }
    // public int nato(int[] arr, int target, int[] dp)
    // {
    //     if(target==0)return 0;
    //     if(target<0)return Integer.MAX_VALUE;
    //     if(dp[target]!=-1)return dp[target];
    //     int min = Integer.MAX_VALUE;
    //     for(int i=arr.length-1; i>-1; i--)
    //     {
    //         int ans = nato(arr,target-arr[i],dp);
    //         if(ans!=Integer.MAX_VALUE)
    //         {
    //             min = Math.min(min,ans+1);
    //         }
    //     }
    //     return dp[target] = min;
    // }
}
