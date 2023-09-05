// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

 

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]

class Solution 
{
    public void sortColors(int[] nums) 
    {
        //int i=0;
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                //swap(nums, mid, i);
                mid++;
            }
            else
            {
                swap(nums, high, mid);
                high--;
            }
            //i++;
        }
    }
    public void swap(int[] arr,int x,int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
