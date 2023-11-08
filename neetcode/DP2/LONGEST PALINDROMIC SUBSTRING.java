//23ms
class Solution 
{
    public int longestPalindromeSubseq(String s) 
    {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return fekung(s,0,n-1,dp); 
    }
    public int fekung(String s, int i, int j, int[][] dp)
    {
        if(i>j)return 0;
        if(i==j)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==s.charAt(j))
        {
            return dp[i][j] = 2+fekung(s,i+1,j-1,dp);
        }
        else
        {
            return dp[i][j] = Math.max(fekung(s,i+1,j,dp),fekung(s,i,j-1,dp));
        }
    }
}
