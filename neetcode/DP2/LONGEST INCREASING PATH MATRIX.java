class Solution 
{
    public int longestIncreasingPath(int[][] matrix) 
    {
        int[][] ansM = new int[matrix.length+2][matrix[0].length+2];
        for(int i=0; i<ansM.length; i++)
        {
            for(int j=0; j<ansM[i].length; j++)
            {
                if(i==0||i==ansM.length-1||j==0||j==ansM[i].length-1)ansM[i][j]=Integer.MIN_VALUE;
                else ansM[i][j]=matrix[i-1][j-1];
            }
        }
        int[][] dp = new int[matrix.length+2][matrix[0].length+2];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        int max = 0;
        for(int i=1; i<ansM.length-1; i++)
        {
            for(int j=1; j<ansM[i].length-1; j++)
            {
                max = Math.max(loda(ansM,i,j,dp),max);
                //System.out.println(ansM[i].length-1);
            }
        }
        return max;
    }
    public int loda(int[][] A, int i, int j,int[][] dp)
    {
        if(i==0||i==A.length-1||j==0||j==A[i].length-1)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max =1;
        if(A[i+1][j]>A[i][j])max = Math.max(1+loda(A,i+1,j,dp),max);
        if(A[i-1][j]>A[i][j])max = Math.max(1+loda(A,i-1,j,dp),max);
        if(A[i][j+1]>A[i][j])max = Math.max(1+loda(A,i,j+1,dp),max);
        if(A[i][j-1]>A[i][j])max = Math.max(1+loda(A,i,j-1,dp),max);
        return dp[i][j]=max;
    }
}
