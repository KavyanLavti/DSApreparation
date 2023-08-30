public void sortStart(int[][] arr, int low, int high)
    {
        if(low<high)
        {
            int newpos = PivotSort(arr, low, high);

            sortStart(arr, low, newpos-1);
            sortStart(arr, newpos+1, high);
        }
    }
    public void Swap(int[][] arr, int i, int j)
    {
        int tempX = arr[i][0];
        int tempY = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = tempX;
        arr[j][1] = tempY;
    }
    public int PivotSort(int[][] arr, int low, int high)
    {
        //last point is pivot
        int pivot = arr[high][0];
        int i = low;
        for(int j=i; j<high; j++)
        {
            if(arr[j][0]<pivot)
            {
                Swap(arr, i, j);
                i++;
            }
        }
        Swap(arr, i, high);
        return i;
    
