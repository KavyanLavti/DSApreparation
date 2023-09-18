// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space


class Solution 
{
    public int singleNonDuplicate(int[] nums) 
    {
       int low =0;
       int high = nums.length-1;
       while(low<high)
       {
            int mid = low+(high-low)/2;

            if(nums[mid]==nums[mid+1])
            {
                if((high-mid)%2==0){low=mid;}
                else{high=mid-1;}
            }
            else if(nums[mid]==nums[mid-1])
            {
                if((mid-low)%2==0){high=mid;}
                else{low=mid+1;}
            }
            else 
            {return nums[mid];}
       }
        return nums[low]; 
    }
}
