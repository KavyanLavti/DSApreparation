class Solution 
{
    public int numDistinct(String s, String t) 
    {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return msg(s,t,0,0,dp);
    }
    public int msg(String s, String t, int id, int idT, int[][] dp)
    {
        if(idT==t.length())return 1;
        if(id==s.length())return 0;
        if(dp[id][idT]!=-1)return dp[id][idT];
        if(t.charAt(idT)==s.charAt(id))
        {
            return dp[id][idT]= msg(s,t,id+1,idT+1,dp)+msg(s,t,id+1,idT,dp);
        }
        else return dp[id][idT]= msg(s,t,id+1,idT,dp);
    }
}
