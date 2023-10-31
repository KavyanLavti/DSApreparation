//0ms 39.82 MB
class Solution 
{
    public int combinationSum4(int[] nums, int target) 
    {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return cum(nums,target,dp);
    }
    public int cum(int[] nums,int target, int[] dp)
    {
        if(target==0)return 1;
        if(target<0)return -1;
        if(dp[target]!=-1)return dp[target];
        int max = 0;
        for(int i=0; i<nums.length; i++)
        {
            int ans = cum(nums,target-nums[i],dp);
            if(ans!=-1)
            {
                max = max+ans;
            }
        }
        return dp[target] = max;
    }
}
