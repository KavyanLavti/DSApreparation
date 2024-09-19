class Solution 
{
    public int maxRotateFunction(int[] nums) 
    {
        int sum = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            max+=i*nums[i];
        }
        int ans = max;
        for(int i=nums.length-1; i>0; i--)
        {
            //max = max-nums[i]*(nums.length-1)+sum-nums[i];
            //nums[i]*(nums.length-1) -> ith element goes from addind by *(n-1) to adding by *0
            //sum-nums[i] -> all the other numbers increases by *1
            //(0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 25
            //(1 * 4) + (2 * 3) + (3 * 2) + (0 * 6) = 25 - 6*3 + (15-6) -> sum = 15
            max = max-nums[i]*(nums.length)+sum;
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
