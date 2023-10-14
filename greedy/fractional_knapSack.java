import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution 
{
    public static double maximumValue(Pair[] items, int n, int w) 
	{
		double maxW = 0;
		double maxV = 0;
		sortDiff(items,0,items.length-1);
		int i = n-1;
		while(i>=0)
		{
			//if(maxW==w)return maxV;
			double z = maxW+items[i].weight;
			if(z<=w)
			{
				maxW =z;
				maxV += items[i].value;
			}
			else
			{
				double k = (double)items[i].value/(double)items[i].weight;
				maxV += (w-maxW)*k;
				maxW = w;
				break;
			}
			i--;
		}
		return maxV;
    }
	public static void sortDiff(Pair[] arr, int low, int high)
    {
        if(low<high)
        {
            int pointer = low;
            double X = (double)arr[high].value/(double)arr[high].weight;
            for(int i=low; i<high; i++)
            {
                if((double)arr[i].value/(double)arr[i].weight<X)
                {
                    swap(arr,i,pointer);
                    pointer++;
                }
            }
            swap(arr,high,pointer);

            sortDiff(arr, low, pointer-1);
            sortDiff(arr, pointer+1, high);
        }
        return;
    }
    public static void swap(Pair[] arr, int x, int y)
    {
        Pair temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
        return;
    }
}
