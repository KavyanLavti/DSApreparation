class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        //ill try QuickSorting the fuck out of this shit
        quickSort(intervals, 0, intervals.length-1);
        List<List<Integer>> abs = new ArrayList<List<Integer>>();
        //boolean t = false;
        for(int i=0; i<intervals.length; i++)
        {
            List<Integer> l1 = new ArrayList<Integer>();
            List<Integer> l2 = new ArrayList<Integer>();
            //l1=null;
            if(!abs.isEmpty())
            {
                l2=abs.get(abs.size()-1);

                if(l2.get(1)>=intervals[i][0])
                {
                    int min = Math.min(l2.get(0),intervals[i][0]);
                    int max = Math.max(l2.get(1), intervals[i][1]);

                    l1.add(min);
                    l1.add(max);

                    abs.remove(abs.size()-1);
                }
                else
                {
                    l1.add(intervals[i][0]);
                    l1.add(intervals[i][1]);
                }
            }
            else
            {
                l1.add(intervals[i][0]);
                l1.add(intervals[i][1]);
            }
            abs.add(l1);
        }
        int[][] XXX_com = new int[abs.size()][2];
        for(int i=0; i<XXX_com.length; i++)
        {
            List<Integer> l1 = new ArrayList<Integer>();
            l1 = abs.get(i);
            XXX_com[i][0] = l1.get(0);
            XXX_com[i][1] = l1.get(1);
        }
        return XXX_com;
    }
    void quickSort(int[][] arr, int low, int high)
    {
        if(low<high)
        {
            int pivot = arr[high][0];
        
            for(int i=low; i<high; i++)
            {
                if(arr[i][0]<pivot)
                {
                    swap(arr,i,low);
                    low++;
                }
            }
            swap(arr,low,high);

            quickSort(arr, 0, low-1);
            quickSort(arr, low+1, high);
        }
        return;
    }
    void swap(int[][] arr, int x, int y)
    {
        int temp1 = arr[x][0];
        int temp2 = arr[x][1];
        arr[x][0] = arr[y][0];
        arr[x][1] = arr[y][1];
        arr[y][0] = temp1;
        arr[y][1] = temp2;
    }
}
