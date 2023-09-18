//Search in an rotated array

//2*O(log(n))

//for O(log(n)) read striver sheet

class Solution 
{
    public int search(int[] nums, int target) 
    {
        int low=0;
        int high=nums.length-1;

        while(low<high)
        {
            int mid = low+(high-low)/2;

            if(nums[mid]>nums[mid+1])
            {
                low=mid;
                break;
            }
            else if(nums[mid]>=nums[0])
            {
                low=mid+1;
            }
            else if(nums[mid]<nums[0])
            {
                high=mid-1;
            }
        }
        if(target>=nums[0])
        {
            return BsSA(nums, target, 0 , low);
        }
        else
        {
            return BsSA(nums, target, low+1, nums.length-1);
        }
    }
    public int BsSA(int[] arr, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]<target){low=mid+1;}
            else if(arr[mid]>target){high=mid-1;}
            else{return mid;}
        }
        return -1;
    }
}
