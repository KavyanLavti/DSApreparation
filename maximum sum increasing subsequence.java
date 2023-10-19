import java.util.* ;
import java.io.*; 

public class Solution 
{
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) 
    {
        int z=0;
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0; i<n; i++)
        {
            z = Math.max(z,maxSum(rack,i,h));
        }
        return z;
    }
    public static int maxSum(ArrayList<Integer> rack, int end, HashMap<Integer,Integer> h)
    {
        if(end<0)return 0;
        if(h.containsKey(end))
        {
            return h.get(end);
        }
        else
        {
            int max = 0;
            for(int i=0; i<end; i++)
            {
                if(rack.get(i)<rack.get(end))
                {
                    max = Math.max(max,maxSum(rack,i,h));
                }
            }
            h.put(end,max+rack.get(end));
            return max+rack.get(end);
        }
    }
}
