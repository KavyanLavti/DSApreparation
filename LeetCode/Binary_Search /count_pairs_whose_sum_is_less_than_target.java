//Given a 0-indexed integer array nums of length n and an integer target, 
//return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.

class Solution 
{
    public int countPairs(List<Integer> nums, int target) 
    {
        Collections.sort(nums);
        int ans = 0;
        int start = 0;
        int end = nums.size()-1;

        while(start<end)
        {
            if(nums.get(start)+nums.get(end)<target)
            {
                ans+=end-start;
                start++;
            }
            else
            {
                end--;
            }
        }
        return ans;
    }
}
