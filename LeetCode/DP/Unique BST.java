Given an integer n, return the number of structurally unique BSTs 
(binary search trees) which has exactly n nodes of unique values from 1 to n.

class Solution 
{
    public int numTrees(int n) 
    {
       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);
       return dickLover(n,dp); 
    }
    public int dickLover(int n, int[] dp)
    {
        if(n==1||n==0)return 1;
        if(dp[n]!=-1)return dp[n];

        int ans = 0;
        for(int i=0; i<n; i++)
        {
            ans += dickLover(i,dp)*dickLover(n-1-i,dp);
            //System.out.println(ans);
        }
        return dp[n] = ans; 
    }
}
