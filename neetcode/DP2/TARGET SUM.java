//6ms
class Solution 
{
    public int findTargetSumWays(int[] nums, int target) 
    {
        int s = 0;
        for(int i:nums)s+=i;
        int[][] dp = new int[nums.length][s+1];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return anseri(nums,target,0,0,0,dp);
    }
    public int anseri(int[] nums, int target, int s1, int s2,int id, int[][] dp)
    {
        if(id==nums.length)
        {
            return (s1-s2==target) ? 1:0;
        }
        if(dp[id][s1]!=-1)return dp[id][s1];
        return dp[id][s1]= anseri(nums,target,s1+nums[id],s2,id+1,dp)+anseri(nums,target,s1,s2+nums[id],id+1,dp);
    }
}
