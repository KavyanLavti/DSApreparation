//ALWAYS PUT THE INDEX WHICH WE ARE CALCULATING IN STORAGE
//OTHERWISE MESS UP
class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0; i<dp.length; i++)
        {
            for(int j=0; j<dp[0].length; j++)
            {
                dp[i][j]=-1;
            }
        }
        return zinda(text1, text2, text1.length()-1, text2.length()-1,dp);
    }
    public int zinda(String t1, String t2, int id1, int id2, int[][] dp)
    {
        if(id1<0||id2<0)return 0;
        if(dp[id1][id2]!=-1)return dp[id1][id2];
        if(t1.charAt(id1)==t2.charAt(id2))
        { 
            return dp[id1][id2] = zinda(t1,t2,id1-1,id2-1,dp)+1;
        }
        else
        {
            return dp[id1][id2] = Math.max(zinda(t1,t2,id1-1,id2,dp),zinda(t1,t2,id1,id2-1,dp));
        }
    }
}
