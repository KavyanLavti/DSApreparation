class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        Deque<Integer> q1 = new ArrayDeque<>();
        int n = nums.length;
        int indexMin = 0;
        int[] arr = new int[n-k+1];

        for(int i=0; i<n; i++)
        {
            while(!q1.isEmpty() && nums[q1.getLast()]<=nums[i])
            {
                q1.removeLast();
            }
            while(!q1.isEmpty() && q1.getFirst()<indexMin)
            {
                q1.removeFirst();
            }
            q1.addLast(i);
            if(i>=k-1)
            {
                arr[i-k+1] = nums[q1.getFirst()];
                indexMin++;
            }
        }
        return arr;
    }

// THIS IS ALSO A GOOD METHOD  
  

    // public int[] maxSlidingWindow(int[] nums, int k) 
    // {
    //     int[] arr = new int[nums.length-k+1];
    //     int index = -1;
    //     for(int i=0; i<arr.length; i++)
    //     {
    //         if(index<i)
    //         {
    //             int[] cock = new int[2];
    //             cock = maxInArr(nums,i,i+k-1);
    //             arr[i] = cock[0];
    //             index = cock[1];
    //         }
    //         else
    //         {
    //             if(nums[index]<=nums[i+k-1])
    //             {
    //                 index = i+k-1;
    //             }
    //             arr[i] = nums[index];
    //         }
    //     }
    //     return arr;
    // }
    // public int[] maxInArr(int[] nums, int x, int y)
    // {
    //     int[] X = new int[2];
    //     int max = Integer.MIN_VALUE;
    //     int index = 0;
    //     for(int i=x; i<=y; i++)
    //     {
    //         if(nums[i]>=max)
    //         {
    //             max = nums[i];
    //             index = i;
    //         }
    //     }
    //     X[0] = max;
    //     X[1] = index;
    //     return X;
    // }
}
