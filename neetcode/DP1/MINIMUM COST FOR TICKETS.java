//1ms
class Solution 
{
    public int mincostTickets(int[] days, int[] costs) 
    {
        int[] dp = new int[days[days.length-1]+1];
        Arrays.fill(dp,-1);
        return semen(days,costs,days[0],dp);
    }
    public int semen(int[] days, int[] cost, int id, int[] dp)
    {
        if(id>days[days.length-1])return 0;
        if(dp[id]!=-1)return dp[id];

        int next1 = fn(id+1,days);
        int next2 = fn(id+7,days);
        int next3 = fn(id+30,days);

        int l = semen(days,cost,next1,dp)+cost[0];
        int m = semen(days,cost,next2,dp)+cost[1];
        int n = semen(days,cost,next3,dp)+cost[2];

        l=Math.min(l,m);
        l=Math.min(l,n);

        return dp[id] =l;
    }
    public int fn(int id, int[] days)
    {
        for(int i=0; i<days.length; i++)
        {
            if(days[i]>=id)return days[i];
        }
        return id;
    }
}
