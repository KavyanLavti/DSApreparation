You are given a 
binary array
 nums.

You can do the following operation on the array any number of times (possibly zero):

Choose any 3 consecutive elements from the array and flip all of them.
Flipping an element means changing its value from 0 to 1, and from 1 to 0.

Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.











class Solution 
{
    public int minOperations(int[] nums) 
    {
        int ans=0;
        for(int i=0; i<nums.length-2; i++)
        {
            if(nums[i]==0)
            {
                ans++;
                for(int j=i;j<=i+2;j++)
                {
                    nums[j] = (nums[j]+1)%2;
                }
            }
        }
        int n = nums.length;
        if(nums[n-1]==0||nums[n-2]==0)return -1;
        return ans;
    }
}
