//Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

import java.io.*;
import java.util.* ;
import java.util.ArrayList;

public class Solution 
{
	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) 
	{
		HashMap<Integer,Integer> h = new HashMap<>();
		//List<Integer> l1 = new ArrayList<Integer>();
    
    //CAN BE DONE WITH FUCKING LISTS ALSO BUT .CONTAION() BOOLEAN SEARCH IS O(n) IN LISTES WHILE O(1) IN HASHMAP
    
        int sum = 0;
        int MaxLen =0;
        h.put(sum,0);
        
        for(int i=0; i<arr.size(); i++)
        {
            sum = sum + arr.get(i);
            if(h.containsKey(sum))
            {
                int index = h.get(sum);
                MaxLen = Math.max(MaxLen, i-index+1);
            }
            else
            {
                h.put(sum,i+1);
            }
        }
        
        return MaxLen;	
	}
}
