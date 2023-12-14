class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            if(h.containsKey(nums[i]))return true;
            h.put(nums[i],0);
        }
        return false;
    }
}
