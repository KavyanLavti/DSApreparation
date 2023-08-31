public class Solution 
{
    public IList<int> MajorityElement(int[] nums) 
    {
        List<int> list1 = new List<int>();
        int n=nums.Length;

        int c1=0;
        int c2=0;

        int e1=-20000;
        int e2=-20000;

        for(int i=0; i<n; i++)
        {
            if(c1==0 && nums[i]!=e2)
            {
                e1 = nums[i];
                c1=1;
            }
            else if(c2==0 && nums[i]!=e1)
            {
                e2 = nums[i];
                c2=1;
            }
            else if(nums[i]==e1)
            {
                c1++;
            }
            else if(nums[i]==e2)
            {
                c2++;
            }
            else{c1--;c2--;}
        }
        c1=0;
        c2=0;
        for(int j=0; j<n; j++)
        {
            if(nums[j]==e1){c1++;}
            else if(nums[j]==e2){c2++;}
        }

        if(c1>n/3){list1.Add(e1);}
        if(c2>n/3){list1.Add(e2);}
        return list1;
    }
}
