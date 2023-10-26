class Solution 
{
    public int numDecodings(String s) 
    {
        int[] dp = new int[s.length()+2];
        Arrays.fill(dp,-1);
        return madar(s,0,dp);
    }
    public int madar(String s, int id, int[] dp)
    {
        if(id==s.length())return dp[id] = 1;
        if(id>s.length()||s.charAt(id)=='0')return dp[id] = 0;
        if(id==s.length()-1)return dp[id] = 1;
        if(dp[id]!=-1)return dp[id];
        if(s.charAt(id)=='1')
        {
            int X = madar(s,id+1,dp);
            int Y = madar(s,id+2,dp);
            return dp[id] = X+Y;
        }
        if(s.charAt(id)=='2')
        {
            if(Integer.valueOf(s.charAt(id+1))>54)
            {
                return dp[id] = madar(s,id+1,dp);
            }
            else
            {
                int X = madar(s,id+1,dp);
                int Y = madar(s,id+2,dp);
                return dp[id] = X+Y;
            }
        }
        return dp[id] = madar(s,id+1,dp);
    }
}
