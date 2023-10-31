class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        // int x = coinCount(coins,amount,dp);
        // if(x==Integer.MAX_VALUE)return -1;
        // return x;

        dp[0] = 0;
        for(int i=0; i<=amount; i++)
        {
            for(int j=0; j<coins.length; j++)
            {
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE)
                {
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }
        return (dp[amount]==Integer.MAX_VALUE) ? -1 : dp[amount];
    }
    // public int coinCount(int[] coins, int amount, int[] dp)
    // {
    //     if(amount==0)return 0;
    //     if(amount<0)return Integer.MAX_VALUE;
    //     if(dp[amount]!=-1)return dp[amount];
    //     int min = Integer.MAX_VALUE;
    //     for(int i=0; i<coins.length; i++)
    //     {
    //         int ans = coinCount(coins,amount-coins[i],dp);
    //         if(ans!=Integer.MAX_VALUE)
    //         {
    //             min = Math.min(min,ans+1);
    //         }
    //     }
    //     return dp[amount] = min;
    // }
}
