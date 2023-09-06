// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
// Return k.

class Solution 
{
    public int removeDuplicates(int[] nums)
    {
        int c=0;
        int rep =-2589634;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]!=rep)
            {
                rep=nums[i];
                swap(nums,i,c);
                c++;
            }
        }
        return c;
    }
    public void swap(int[] arr, int u, int v)
    {
        int temp = arr[u];
        arr[u]=arr[v];
        arr[v]=temp;
    }
    // public int merge(int[] arr, int low, int mid, int high)
    // {
    //     int l1=mid-low+1;
    //     int l2= high-mid;

    //     int[] a1 = new int[l1];
    //     int[] a2 = new int[l2];
        
    //     int i=0,j=0,k=0;

    //     for(i=0; i<l1; i++)
    //     {
    //         a1[i]=arr[low+i];
    //     }
    //     for(j=0; j<l2; j++)
    //     {
    //         a2[i]=arr[mid+j+1];
    //     }

    //     i=0;j=0;

    //     while(i<l1&&j<l2)
    //     {
    //         if(a1[i]<a2[j])
    //         {
    //             arr[k+low]=a1[i];
    //             i++;
    //         }
    //         else if(a1[i]==a2[j])
    //         {
    //             arr[k+low]=a1[i];
    //             i++;
    //             j++;
    //         }
    //         else
    //         {
    //             arr[k+low]=a2[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     while(i<l1)
    //     {
    //         arr[k+low]=a1[i];
    //         i++;
    //         k++;
    //     }
    //     while(j<l2)
    //     {
    //         arr[k+low]=a2[j];
    //         j++;
    //         k++;
    //     }
    //     return k;
    // }
    // public void sort(int[] arr, int low, int high)
    // {
    //     if(low<high)
    //     {
    //         int mid = low+ (high-low)/2;

    //         sort(arr, low, mid);
    //         sort(arr, mid+1, high);

    //         c=merge(arr, low, mid, high);
    //     }
    // }
}
