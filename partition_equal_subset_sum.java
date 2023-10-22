class Solution 
{
    public boolean canPartition(int[] nums) 
    {
        int target = 0;
        for(int i=0; i<nums.length; i++)
        {
            target += nums[i];
        }
        if(target%2!=0)return false;
        int[][] dp = new int[target/2+1][nums.length];
        for(int i=0; i<dp.length; i++)
        {
            for(int j=0;j<nums.length; j++)
            {
                dp[i][j]=-1;
            }
        }
        return findsum(nums,target/2,0,dp);
    }
    public boolean findsum(int[] nums, int target, int id, int[][] dp)
    {
        if(target==0)return true;
        if(id==nums.length||target<0)return false;

        if(dp[target][id]!=-1)
        {
            if(dp[target][id]==0)return false;
            else return true;
        }
        boolean X = findsum(nums,target,id+1,dp);
        boolean Y = findsum(nums,target-nums[id],id+1,dp);
        if(X||Y)dp[target][id] = 1;
        else dp[target][id] = 0;
        return X||Y;
    }
}
