//0ms, 44.22MB
class Solution 
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return gridtra(m-1,n-1,obstacleGrid,dp);
    }
    public int gridtra(int m, int n, int[][] ob, int[][] dp)
    {
        if(n<0||m<0||ob[m][n]==1)return 0;
        if(n==0 && m==0)return 1;
        if(dp[m][n]!=-1)return dp[m][n];
        return dp[m][n] = gridtra(m-1,n,ob,dp)+gridtra(m,n-1,ob,dp);
    }
}
