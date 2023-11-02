//9ms 50%
class Solution 
{
    public boolean validPartition(int[] nums) 
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return vp(nums,0,dp);

        
    }
    public boolean vp(int[] nums, int id, int[] dp)
    {
        if(id==nums.length)return true;
        if(id==nums.length-1)return false;
        if(dp[id]!=-1)
        {
            return (dp[id]==0) ? false : true;
        }
        boolean b1 = nums[id]==nums[id+1] && vp(nums,id+2,dp);
        if(id==nums.length-2)return b1;
        boolean b2 = nums[id]==nums[id+1] && nums[id]==nums[id+2] && vp(nums,id+3,dp);
        boolean b3 = nums[id+2]==nums[id+1]+1 && nums[id+1]==nums[id]+1 && vp(nums,id+3,dp);
        boolean b4 = b1||b2||b3;
        if(b4)dp[id] = 1;
        else dp[id]=0;
        return b4;
    }
}
