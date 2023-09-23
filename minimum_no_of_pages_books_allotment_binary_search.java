// Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
// Allocate books in such a way that:

// Each student gets at least one book.
// Each book should be allocated to only one student.
// Book allocation should be in a contiguous manner.
// You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1

//a variation of the given problem

import java.util.* ;
import sun.reflect.generics.tree.Wildcard;
import java.io.*; 
public class Solution 
{
    public static long ayushGivesNinjatest(int n, int m, int[] time) 
    {
        {
            //m chapters
            //n days
            //infinite time in one day
            //range from what actually can be the ans, from max(time[i]) to sum(time[i])
            //if we selected x from between them, if for(i<time.length) sort it
            // if we can look store the value and look for less
            // if not look for higher

            //int ans =0;

            long low = 0;
            long high = 0;
            for(int i=0; i<m; i++)
            {
                high+=time[i];
                if(time[i]>low){low = time[i];}
            }
            // if(m<=n)
            // {
            //     return (long)low;
            // }
            //else if(n==1){return (long)high;}

            while(low<=high)
            {
                long mid = low+(high-low)/2;
                int k=0;
                long u=0;
                boolean bullseye = false;

                for(int i=0; i<m; i++)
                {
                    // if((long)time[i]>mid)
                    // {
                    //     bullseye=false;
                    //     break;
                    // }
                    if((long)(u+time[i])>mid)
                    {
                        k++;
                        u=0;
                    }
                    u+=time[i];
                    bullseye=true;
                    if(k>=n)
                    {
                        bullseye = false;
                        break;
                    }
                }
                if(!bullseye)
                {
                    low=mid+1;
                }
                else
                {
                    //ans = mid;
                    high = mid-1;
                }
            }
            return low;
            //System.out.print(ans);
            // int mid = Math.min(low,high);

            //     boolean bullseye = false;
            //     int k=0;
            //     long u=0;

            //     for(int i=0; i<m; i++)
            //     {
            //         if(time[i]>mid)
            //         {
            //             bullseye=false;
            //             break;
            //         }
            //         if(u+time[i]>mid)
            //         {
            //             k++;
            //             u=0;
            //         }
            //         u+=time[i];
            //         bullseye=true;
            //         if(k>=n)
            //         {
            //             bullseye = false;
            //             break;
            //         }
            //     }
            // if(bullseye){return (long)mid;}
            // else{return (long)ans;}
        }
    }
}
