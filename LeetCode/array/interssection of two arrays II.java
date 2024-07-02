Given two integer arrays nums1 and nums2, return an array of their intersection. Each element
 in the result must appear as many times as it shows in both arrays and you may return the result in any order.





class Solution 
{
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        int[] bail = new int[1005];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums1.length; i++)
        {
            bail[nums1[i]]++;
        }
        for(int i=0; i<nums2.length; i++)
        {
            if(bail[nums2[i]]!=0)
            {
                ans.add(nums2[i]);
                bail[nums2[i]]--;
            }
        }
        int[] ans1 = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)
        {
            ans1[i] = ans.get(i);
        }
        return ans1;
    }
}
