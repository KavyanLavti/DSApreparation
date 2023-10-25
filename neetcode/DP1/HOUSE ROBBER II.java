class Solution 
{
    public int rob(int[] nums) 
    {
        int n = nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int X = sexa(nums,n,0,n-2);
        int Y = sexa(nums,n,1,n-1);
        return Math.max(X,Y);
    }
    public int sexa(int[] nums, int n, int low, int high)
    {
        int[] dp = new int[n];
        for(int i=low; i<=high; i++)
        {
            if(i<low+2){dp[i]=nums[i];}
            else if(i==low+2){dp[i] = nums[i]+dp[i-2];}
            else {dp[i] = nums[i]+Math.max(dp[i-2],dp[i-3]);}
            //System.out.println(dp[i]);
        }
        return Math.max(dp[high],dp[high-1]);
    }
}
