//1 MS FOR RECURSIVE SOLUTION
//0 MS FOR ITEREATIVE SOLUTION
class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        // int[] dp = new int[cost.length+1];
        // Arrays.fill(dp,-1);
        // return coster(cost,-1,dp);
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<cost.length; i++)
        {
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
    // public int coster(int[] cost, int p, int[] dp)
    // {
    //     if(p>=cost.length-2)return 0;
    //     if(dp[p+1]!=-1)return dp[p+1];
    //     return dp[p+1] = Math.min(cost[p+1] + coster(cost,p+1,dp),cost[p+2] + coster(cost,p+2,dp));
    // }
}
