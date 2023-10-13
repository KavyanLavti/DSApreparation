public class Solution 
{
    public static int maximumMeetings(int []start, int []end) 
    {
        int max =1;
        sortDiff(end, start, 0, start.length-1);
        int limit = end[0];
        for(int i=1; i<start.length; i++)
        {
            if(start[i]>limit)
            {
                max++;
                limit=end[i]; 
            }
        }
        return max;
    }
    public static void sortDiff(int[] start, int[] end, int low, int high)
    {
        if(low<high)
        {
            int pointer = low;
            int X = start[high];
            for(int i =low; i<high; i++)
            {
                if(start[i]<X)
                {
                    swap(end,i,pointer);
                    swap(start,i,pointer);
                    pointer++;
                }
            }
            swap(end,high,pointer);
            swap(start,high,pointer);

            sortDiff(start, end, low, pointer-1);
            sortDiff(start, end, pointer+1, high);
        }
        return;
    }
    public static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return;
    }
}
