public class Solution 
{
    public void Merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int i=0;
        int j=0;
        int k=0;
        for(int papa=m-1; papa>=0; papa--)
        {
            Swap(nums1, papa, papa+n);
        }
        while(i<m && j<n)
        {
            if(nums1[i+n]<=nums2[j])
            {
                nums1[k] = nums1[i+n];
                i++;
            }
            else
            {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<m)
        {
            nums1[k] = nums1[i+n];
            i++;
            k++;
        }
        while(j<n)
        {
            nums1[k] = nums2[j];
            j++;
            k++;
        }

    }
    public void Swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
