class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        int max =0;
        int z = heights.length;
        Stack<Integer> sl = new Stack<>();
        Stack<Integer> sr = new Stack<>();
        int[] arr = new int[heights.length];
        for(int i=0; i<z; i++)
        {
            while(!sl.isEmpty() && (heights[sl.peek()]>=heights[i]))
            {
                arr[sl.pop()]+=i;
            }
            if(sl.isEmpty())
            {
                arr[i] -= 0;
            }
            else{arr[i] -= (sl.peek()+1);}
            sl.push(i);
            while(i==z-1 && !sl.isEmpty())
            {
                arr[sl.pop()]+=z;
            }
        }
        for(int i = 0; i<z; i++)
        {
            max = Math.max(max, heights[i]*(arr[i]));
        }
        return max;

// this is also a method calculate right and left seperataly using stack O(N)
      
        int max =0;
        int z = heights.length;
        Stack<Integer> sl = new Stack<>();
        Stack<Integer> sr = new Stack<>();
        int[] arr = new int[heights.length];
        for(int i=0; i<z; i++)
        {
            while(!sl.isEmpty() && (heights[sl.peek()]>=heights[i]))
            {
                sl.pop();
            }
            if(sl.isEmpty())
            {
                arr[i] -= 0;
            }
            else{arr[i] -= (sl.peek()+1);}
            sl.push(i);

            while(!sr.isEmpty() && heights[sr.peek()]>=heights[z-i-1])
             {
                 sr.pop();
             }
             if(sr.isEmpty()){arr[z-1-i] += z-1;}
             else{arr[z-1-i] += sr.peek()-1;}
             sr.push(z-1-i);
        }
        for(int i = 0; i<z; i++)
        {
            max = Math.max(max, heights[i]*(arr[i]));
        }
        return max;
//O(N^2);

        // int max = 0;
        // for(int i=0; i<heights.length; i++)
        // {
        //     int l=0, r=1;
        //     int j=i-1, k=i+1;
        //     while(j>=0 && heights[j]>=heights[i])
        //     {
        //         l++;
        //         j--;
        //     }
        //     while(k<heights.length && heights[k]>=heights[i])
        //     {
        //         r++;
        //         k++;
        //     }
        //     max = Math.max(max, heights[i]*(l+r));
        // }
        // return max;
    }
}
