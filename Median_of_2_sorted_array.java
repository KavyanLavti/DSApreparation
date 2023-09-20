//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).


class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        //System.out.print(Math.min(-1,3));
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1==0)
        {
            if(n2%2==0){return (double)(nums2[n2/2]+nums2[(n2-1)/2])/2;}
            else return (double)nums2[n2/2];
        }

        if(n2<n1){return findMedianSortedArrays(nums2, nums1);}
        int low = 0;
        int high = n1;

        while(low<high)
        {
            int x = low+(high-low)/2;

            int l1 = Integer.MIN_VALUE;
            if((double)x>0.0){l1 = nums1[x-1];}
            int l2 = nums2[(n1+n2)/2-x-1];//Integer.MIN_VALUE;
            //if(x<(n1+n2)/2-1){l2 = nums2[(n1+n2)/2-x-1];}
            int r1 = nums1[x];//Integer.MAX_VALUE;
            //if(x<n1){r1 = nums1[x];}
            int r2 = Integer.MAX_VALUE;
            if((double)x>(double)(n1-n2)/2){r2 = nums2[(n1+n2)/2-x];}

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
                if((n1+n2)%2==0){return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;}
                else{return (double)Math.min(r1,r2);}
            }
        }
        int x = low;

        int l1 = Integer.MIN_VALUE;
        if((double)x>0.0){l1 = nums1[x-1];}
        int l2 = Integer.MIN_VALUE;
        if((double)x<=(double)(n1+n2)/2-1){l2 = nums2[(n1+n2)/2-x-1];}
        int r1 = Integer.MAX_VALUE;
        if((double)x<(double)n1){r1 = nums1[x];}
        int r2 = Integer.MAX_VALUE;
        if((double)x>(double)(n1-n2)/2){r2 = nums2[(n1+n2)/2-x];} 

        if((n1+n2)%2==0){return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;}
        else{return (double)Math.min(r1,r2);}  
    }
}
