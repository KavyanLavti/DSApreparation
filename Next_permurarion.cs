public class Solution 
{
    public void NextPermutation(int[] nums) 
    {
        int i = nums.Length;
        int damn = i;
        int index = i-1;
        //int nextMin =0;
        if(i==1){return;}
        while(nums[damn-1]<=nums[damn-2])
        {
            index = damn-2;
            if(index==0)
            {
                //last permutation 
                break;
            }
            damn--;
        }
        //find the immidiate next to nums[index-1]
        int nextMin = index;
        if((nextMin-1)>=0)
        {
            for(int u = index; u<i; u++)
            {
            if(nums[u]>nums[index-1] && nums[u]<nums[nextMin])
            {
                nextMin = u;
            }
            }
            int tempHolder = nums[index-1];
            nums[index-1] = nums[nextMin];
            nums[nextMin] = tempHolder;
        }
        for(int m = index; m<i; m++)
        {
            //int newNextMin = nextMin+1];
            int newNextMin = m;
            for(int n=m+1; n<i; n++)
            {
                if(nums[n]<nums[newNextMin])
                {
                    newNextMin = n;
                }
            }
            int tempHolder2 = nums[m];
            nums[m] = nums[newNextMin];
            nums[newNextMin] = tempHolder2;
        }
    }
}
