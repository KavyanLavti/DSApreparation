// 2ms 41.02MB
class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return sexa(s,wordDict,0,dp);
    }
    public boolean sexa(String s, List<String> wordDict, int id, int[] dp)
    {
        if(id==s.length())return true;
        if(id>s.length())return false;
        if(dp[id]!=-1)return (dp[id]==1)?true:false;
        boolean xaxa = false;
        for(int i=0; i<wordDict.size(); i++)
        {
            boolean atta = false;
            String p = wordDict.get(i);
            if(id+p.length()>s.length()||p.equals(s.substring(id,id+p.length())))
            {
                atta = sexa(s,wordDict,id+p.length(),dp);
            }
            xaxa = xaxa||atta;
        }
        if(xaxa)dp[id]=1;
        else dp[id]=0;
        return xaxa;
    }
}
