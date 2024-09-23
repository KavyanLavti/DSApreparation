class Solution 
{
    public int minFallingPathSum(int[][] matrix) 
    {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] rw:dp)Arrays.fill(rw,-1000000);
        //CANNOT INITIALISE TO -1 AS MATRIX HAVE BOTH -VE AND POSITIVE ELEMENTS TEST CASE 49 GIVE TLE BECAUSE OF THIS AS IS THE SUM COMES TO -1 THE DP SOLUTION WOUDNT WORK AND IT WILL CALCULATE AGAIN AND AGAIN
        for(int i=0; i<matrix[0].length; i++)
        {
            min = Math.min(min,mina(matrix,0,i,dp));
        }
        return min;
    }
    public int mina(int[][] mat, int i, int j, int[][] dp)
    {
        if(i>=mat.length)return 0;
        if(j<0||j>=mat[0].length)return 100000;
        if(dp[i][j]!=-1000000)return dp[i][j];
        return dp[i][j] = mat[i][j]+Math.min(mina(mat,i+1,j-1,dp),Math.min(mina(mat,i+1,j,dp),mina(mat,i+1,j+1,dp)));
    } 
}
