import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

import sun.util.logging.resources.logging;

public class Solution 
{
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) 
    {
        int sum = 0;
        int X = n*(n+1)/2;
        int[] ans = new int[2];

        for(int i=0; i<n; i++)
        {
            sum = sum + Math.abs(arr.get(i));
            if(arr.get(Math.abs(arr.get(i))-1)>0)
            {
                arr.set(Math.abs(arr.get(i))-1,-arr.get(Math.abs(arr.get(i))-1));
            }
            else
            {
                ans[1] = Math.abs(arr.get(i));
            }
        }

        ans[0] = ans[1] + X - sum;
        return ans;

// ALSO GREAT MATH SOLUTION BUT RANGE STACK OVERFLOW PROBLEM
        // double sumAbs = n*(n+1)/2;
        // double sumSqAbs = n*(n+1)*(2*n+1)/6;
        // double sumPr =0, sumSqPr=0;

        // for(int i=0; i<arr.size(); i++)
        // {
        //     int x = arr.get(i);
        //     sumPr += (double)x;
        //     sumSqPr += (double)x*(double)x;
        // }

        // int[] ans = new int[2];

        // ans[0] = (int)((sumAbs-sumPr)+(sumSqAbs-sumSqPr)/(sumAbs-sumPr))/2;
        // ans[1] = (int)(ans[0] - (sumAbs-sumPr));

        // return ans;
    }
}
