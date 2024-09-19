class Solution 
{
    public int numberOfArithmeticSlices(int[] nums) 
    {
        if(nums.length<3)return 0;
        for(int i=nums.length-1; i>0; i--)
        {
            nums[i] = nums[i] - nums[i-1];
        }
        List<Integer> l1 = new ArrayList<>();
        int cnt = 1;
        int prev = 3000;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]==prev)
            {
                cnt++;
            }
            else
            {
                if(cnt>=2)l1.add(cnt);
                cnt=1;
                prev=nums[i];
            }
        }
        if(cnt>=2)l1.add(cnt);
        int ans = 0;
        for(int i=0; i<l1.size(); i++)
        {
            int x = l1.get(i);
            ans += x*(x-1)/2;
            // add all the windows for 5 youll add (2)->4 + (3)-> 3+(2)->2+ (5)->1
        }
        return ans;
    }
}
