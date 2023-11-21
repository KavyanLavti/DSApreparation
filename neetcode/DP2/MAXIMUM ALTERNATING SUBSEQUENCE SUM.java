class Solution 
{
    public long maxAlternatingSum(int[] nums) 
    {
        long[][] dp = new long[nums.length][2];
        for(long[] rw:dp)Arrays.fill(rw,-1);
        return msg(nums,0,0,dp);
    }
    public long msg(int[] nums, int id, int s, long[][] dp)
    {
        if(id>=nums.length)return 0;
        if(dp[id][s]!=-1)return dp[id][s];
        long ans=0;
        if(s%2==0)
        {
            ans=msg(nums,id+1,1,dp)+nums[id];
        }
        else
        {
            ans=msg(nums,id+1,0,dp)-nums[id];
        }
        ans = Math.max(ans,msg(nums,id+1,s,dp));
        return dp[id][s]=ans;
    }
}
