class Solution 
{
    public int minDistance(String word1, String word2) 
    {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return npc(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    public int npc(String w1, String w2, int id1, int id2,int[][] dp)
    {
        if(id2<0)return id1+1;
        if(id1<0)return id2+1;
        if(dp[id1][id2]!=-1)return dp[id1][id2];
        if(w1.charAt(id1)==w2.charAt(id2))
        {
            return dp[id1][id2]=npc(w1,w2,id1-1,id2-1,dp);
        }
        else return dp[id1][id2]=1+Math.min(npc(w1,w2,id1,id2-1,dp)//insertion
        ,Math.min(npc(w1,w2,id1-1,id2,dp),//deletion
        npc(w1,w2,id1-1,id2-1,dp)));//replace
    }
}
