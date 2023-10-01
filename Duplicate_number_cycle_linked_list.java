// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and uses only constant extra space.
class Solution 
{
    public int findDuplicate(int[] nums) 
    {
        int slow =nums[0];
        int fast =nums[0];
        int dummy = nums[0];
        boolean lodamera=false;
        while(slow!=fast||!lodamera)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
            lodamera = true;
        }
        while(dummy!=slow)
        {
            dummy = nums[dummy];
            slow = nums[slow];
        }
        return dummy;
    }
}
