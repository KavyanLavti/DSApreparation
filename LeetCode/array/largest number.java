class Solution 
{
    public String largestNumber(int[] nums) 
    {
        CustomSort(nums,0,nums.length-1);
        //IF EVEN AFTER SORTING THE HIGHEST NUMBER IS ZERO RETURN ZERO ONLY
        //THIS IS FOR THE CASE [0,0];
        if(nums[0]==0)return "0";
        String ans = "";
        for(int i=0; i<nums.length; i++)
        {
            ans+=Integer.toString(nums[i]);
        }
        return ans;
    }
    public void CustomSort(int[] nums, int low, int high)
    {
        if(low<high)
        {
            int comp = nums[high];
            int pointer = low;
            for(int i=low; i<high; i++)
            {
                //THINK
                long long1 = (long)nums[i]*(long)digitCnt(comp)+(long)comp;
                long long2 = (long)comp*(long)digitCnt(nums[i])+(long)nums[i];
                if(long1>long2)
                {
                    swap(nums,pointer,i);
                    pointer++;
                }
            }
            swap(nums,pointer,high);
            CustomSort(nums,low,pointer-1);
            CustomSort(nums,pointer+1,high);
        }
    }
    public void swap(int[] nums, int x, int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public int digitCnt(int x)
    {
        if(x==0)return Integer.MAX_VALUE;
        //IF THE DIGIT IS ZERO WE WANT IT TO BE AT LAST PLACE HENCE WANT LONG2>LONG1 IN CUSTOMSORT
        int ans = 1;
        while(x!=0)
        {
            ans*=10;
            x=x/10;
        }
        return ans;
    }
}
