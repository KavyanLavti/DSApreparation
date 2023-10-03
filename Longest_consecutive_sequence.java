// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

//WHAT WE LEARN
//IF I PUT THE IF CONDITION WHILE CHECKING HASHMAP MULTIPLE NON STARTING STARTS WILL HAVE BEEN PRODUCED
//SO WE PUT IT BELOW

class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        int count = 1;
        int longest = 1;
        //List<Integer> start = new ArrayList<>();
        Set<Integer> h = new HashSet<>();
        if(nums.length==0){return 0;}
        for(int i=0; i<nums.length; i++)
        {
            h.add(nums[i]);
        }
        for(int id : h)
        {
            count = 1;
            if(!h.contains(id-1))
            {
                int x = id;
                while(h.contains(x+1))
                {
                    count++;
                    x++;
                }
            }
            longest = Math.max(longest,count);
        }
        return longest;   
    }
}
