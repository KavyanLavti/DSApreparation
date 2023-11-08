//4ms
class Solution 
{
    public int lastStoneWeightII(int[] stones) 
    {
        int sum = 0;
        int s2=0;
        int n=stones.length;
        for(int i:stones)sum+=i;
        boolean[][] dp= new boolean[n+1][sum/2+1];
        for(int i=0; i<dp.length; i++)
        {
            dp[i][0]=true;
        }
        for(int i=1; i<dp.length; i++)
        {
            for(int s=1; s<=sum/2; s++)
            {
                if(dp[i-1][s]||s>=stones[i-1] && dp[i-1][s-stones[i-1]])
                {
                    dp[i][s]=true;
                    s2=Math.max(s2,s);
                }
            }
        }
        return sum-2*s2;
    }
}
