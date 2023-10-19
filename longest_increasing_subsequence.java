// COMMENTED OUT IS A O(N^2) SOLUTION -> THE DP SOLUTION
// NON COMMENTED IS A BINARY SEARCH O(NLOG(N)) SOLUTION
class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        List<Integer> l1 = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int x = l1.size();
            if(x==0||nums[i]>l1.get(x-1))
            {
                l1.add(nums[i]);
            }
            else
            {
                int low = 0;
                int high = x-1;
                while(low<=high)
                {
                    int m = (low+high)/2;
                    
                    if(l1.get(m)<nums[i])
                    {
                        low = m+1;
                    }
                    else
                    {
                        high = m-1;
                    }
                }
                l1.set(low,nums[i]);
            } 
        }
        return l1.size();
        // int z = 0;
        // HashMap<Integer,Integer> sexa = new HashMap<>();
        // for(int i=0; i<=nums.length-1; i++)
        // {
        //     z = Math.max(z,len(nums,i,sexa));
        // }
        // return z;
    }
    // public int len(int[] nums, int end, HashMap<Integer,Integer> h)
    // {
    //     if(end==0)return 1;
    //     if(nums.length==0||nums.length==1)return nums.length;

    //     int max = 0;
    //     for(int i=0; i<end; i++)
    //     {
    //         if(nums[i]<nums[end])
    //         {
    //             int j; 
    //             if(h.containsKey(i))
    //             {
    //                 j= h.get(i);
    //             }
    //             else
    //             {
    //                 j = len(nums,i,h);
    //             }
    //             max = Math.max(max,j);
    //         }
    //     }
    //     h.put(end, max+1);
    //     return max+1;
    // }
}
