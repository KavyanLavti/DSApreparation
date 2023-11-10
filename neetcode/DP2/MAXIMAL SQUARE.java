class Solution 
{
    public int maximalSquare(char[][] matrix) 
    {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int max =0;
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[i].length; j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
