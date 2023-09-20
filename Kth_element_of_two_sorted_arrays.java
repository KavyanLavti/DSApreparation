//Given two arrays arr1 and arr2 of size N and M respectively and an element K. 
//The task is to find the element that would be at the kth position of the final sorted array.

class Solution 
{
    public long kthElement( int nums1[], int nums2[], int n1, int n2, int k) 
    {
        //System.out.print(Math.min(-1,3));
        //int n1 = nums1.length;
        //int n2 = nums2.length;
        if(n1==0)
        {
            return (long)nums2[k-1];
            //else return (double)nums2[n2/2];
        }

        if(n2<n1){return kthElement(nums2, nums1, n2, n1, k);}
        int low = Math.max(0,k-1-n2);
        int high = Math.min(n1,k-1);
        //System.out.print(high);
        
        while(low<high)
        {
            int x = low+(high-low)/2; 

            int l1 = Integer.MIN_VALUE;
            if(x>0){l1 = nums1[x-1];}
            int l2 = nums2[k-2-x];//= Integer.MIN_VALUE;
            //if(x<=(k-2) && x>k-n2-2){l2 = nums2[k-2-x];}
            int r1 =  nums1[x];//Integer.MAX_VALUE;
            //if(x<n1){r1 = nums1[x];}
            int r2 = Integer.MAX_VALUE;
            if(x>(k-1-n2)){r2 = nums2[k-1-x];}

            if(l1>r2)
            {
                high = x-1;
                //System.out.print("F");
            }
            else if(l2>r1)
            {
                low = x+1;
                //System.out.print("S");
            }
            else
            {   //System.out.print(r1);
                //System.out.print(r2);
                return (long)Math.min(r1,r2);
            }
        }
        int x = low;

        int l1 = Integer.MIN_VALUE;
        if(x>0){l1 = nums1[x-1];}
        int l2 = Integer.MIN_VALUE;
        if(x<=(k-2) && x>k-n2-2){l2 = nums2[k-1-x-1];}
        int r1 = Integer.MAX_VALUE;
        if(x<n1){r1 = nums1[x];}
        int r2 = Integer.MAX_VALUE;
        if(x>(k-1-n2)){r2 = nums2[k-1-x];}

        return (long)Math.min(r1,r2);
    }
}
