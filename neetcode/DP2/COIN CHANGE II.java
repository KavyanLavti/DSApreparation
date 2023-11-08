class Solution 
{
    public int change(int amount, int[] coins) 
    {
        // int[][] dp = new int[amount+1][coins.length];
        // for(int[] rw:dp)Arrays.fill(rw,-1);
        // return loda(amount,coins,0,dp);   
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int c:coins)
        {
            for(int i=c; i<dp.length; i++)
            {
                dp[i] += dp[i-c];
            }
        }
        return dp[amount];
    }
    // public int loda(int amount, int[] coins, int id, int[][] dp)
    // {
    //     if(amount<0||id==coins.length)return 0;
    //     if(amount==0) return 1;
    //     if(dp[amount][id]!=-1)return dp[amount][id];
    //     return dp[amount][id] = loda(amount-coins[id],coins,id,dp)+loda(amount,coins,id+1,dp);
    // }
}
