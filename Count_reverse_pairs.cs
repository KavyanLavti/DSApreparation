// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
 

// Example 1:

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
// Example 2:

// Input: nums = [2,4,3,5,1]
// Output: 3
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
// (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1


//O(2N*log(N))

//space mine is bad 

//here you will see a different method to increase count, we can do two for loops inside of the if statements as done in globalInversions
//but the time complexity rises 15 folds

// so remember this trick when merging you are travelling upwards and hence the lest and right arr1 & arr2 are already sorted
// so we just go through it
// also 

 int k = 0;
        for(int u=0; u<n1; u++)
        {
            count = count + k;
            while(k<n2 && (long)arr1[u]>((long)2*(long)arr2[k]))
            {
                k++;
                count++;
            }
        }
// this part has time complexity of O(N) only if you see correctly


public class Solution 
{
    int count = 0;
    public int ReversePairs(int[] nums) 
    {
        sort(nums, 0, nums.Length-1);
        return count;
    }
    public void Merge(int[] arr, int l, int m, int h)
    {
        int n1 = m-l+1;
        int n2 = h-m;
        int i=0,j=0;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(i=0;i<n1;i++)
        {
            arr1[i]=arr[l+i];
        }
        for(j=0;j<n2;j++)
        {
            arr2[j]=arr[m+j+1];
        }

        int k = 0;
        for(int u=0; u<n1; u++)
        {
            count = count + k;
            while(k<n2 && (long)arr1[u]>((long)2*(long)arr2[k]))
            {
                k++;
                count++;
            }
        }

        i=0;j=0;k=0;

        while(i<n1 && j<n2)
        {
            if(arr1[i]<=arr2[j])
            {
                arr[k+l]=arr1[i];
                // for(int m1=j; m1<n2; m1++)
                // {
                //     if((long)arr1[i]>(long)(2)*(long)(arr2[m1]))
                //     {
                //         count =count + 1;
                //         //break;
                //     }
                // }
                i++;
            }
            else
            {
                arr[k+l]=arr2[j];
                // for(int m1=i; m1<n1; m1++)
                // {
                //     if((long)arr1[m1]>(long)(2)*(long)(arr2[j]))
                //     {
                //         count =count + n1-m1;
                //         break;
                //     }
                // }
                //Console.WriteLine(count);
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k+l]=arr1[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            arr[k+l]=arr2[j];
            j++;
            k++;
        }
    }
    public void sort(int[] arr, int l, int h)
    {
        if(l<h)
        {
            int m = l+(h-l)/2;

            sort(arr, l, m);
            sort(arr, m+1, h);

            Merge(arr, l, m, h);
        }
    }
}
