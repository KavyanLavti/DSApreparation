class Solution 
{
    public int rob(int[] nums) 
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(sofa(nums,dp,nums.length-1),sofa(nums,dp,nums.length-2));
        // for(int i=0; i<dp.length; i++)
        // {
        //     if(i<2)
        //     {
        //         dp[i] = nums[i];
        //     }
        //     else if(i==2)
        //     {
        //         dp[i] = nums[i] + dp[i-2];
        //     }
        //     else
        //     {
        //         dp[i] = nums[i] + Math.max(dp[i-2],dp[i-3]);
        //     }
        // }
        // if(dp.length==1)
        // {
        //     return dp[0];
        // }
        // return Math.max(dp[dp.length-1],dp[dp.length-2]);
    }
    public int sofa(int[] nums, int[] dp, int id)
    {
        if(id<0)return 0;
        if(id<2)
        {
            return nums[id];
        }
        if(dp[id]!=-1)
        {
            return dp[id];
        }
        else
        {
            return dp[id] = nums[id] + Math.max(sofa(nums,dp,id-2),sofa(nums,dp,id-3));
        }
    }
}
