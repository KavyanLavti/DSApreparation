//0ms
class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        int[][] dp = new int[m][n];
        for(int[] rw: dp)Arrays.fill(rw,-1);
        return up(m-1,n-1,dp);
    }
    public int up(int m, int n, int[][] dp)
    {
        if(m==0||n==0)return 1;
        if(dp[m][n]!=-1)return dp[m][n];
        return dp[m][n] = up(m-1,n,dp)+up(m,n-1,dp);
    }
}
