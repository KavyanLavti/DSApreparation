//214050009@iitb.ac.in
public class Solution 
{
    int GlobalInversions = 0;
    int LocalInversions = 0;
    public bool IsIdealPermutation(int[] nums) 
    {
        for(int i=0; i<nums.Length-1; i++)
        {
            if(nums[i]>nums[i+1])
            {
                LocalInversions++;
            }
        }
        Sort(nums, 0, nums.Length-1);
        // Console.WriteLine(GlobalInversions);
        // Console.WriteLine(LocalInversions);
        // for(int i=0; i<nums.Length; i++)
        // {
        //     Console.Write(nums[i]);
        // }
        // Console.WriteLine();
        return (GlobalInversions==LocalInversions);   
    }
    public void Merge(int[] arr, int low, int mid, int high)
    {
        int len1 = mid-low+1;
        int len2 = high-mid;

        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        for(int m=0; m<len1; m++)
        {
            arr1[m]=arr[m+low];
        }
        for(int n=0; n<len2; n++)
        {
            arr2[n]=arr[mid+n+1];
        }
        
        int i=0,j=0,k=0;
        while(i<len1 && j<len2)
        {
            if(arr1[i]<=arr2[j])
            {
                arr[k+low]=arr1[i];
                i++;
                //Console.WriteLine(GlobalInversions);
            }
            else
            {
                arr[k+low]=arr2[j];
                GlobalInversions = GlobalInversions+len1-i;
                j++;
                //Console.WriteLine(GlobalInversions);
            }
            k++;
        }
        while(i<len1)
        {
            arr[k+low]=arr1[i];
            i++;
            k++; 
        }
        while(j<len2)
        {
            arr[k+low]=arr2[j];
            j++;
            k++;
            //GlobalInversions++; 
        }
        // for(int p=0; p<arr.Length; p++)
        // {
        //     Console.Write(arr[p]);
        // }
        // Console.WriteLine();
    }
    public void Sort(int[] arr, int low, int high)
    {
        if(low<high)
        {
            int mid = low + (high-low)/2;

            Sort(arr, low, mid);
            Sort(arr, mid+1, high);

            Merge(arr, low, mid, high);
        }
    }
}
