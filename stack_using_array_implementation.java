
//Implement Stack Using ARRAY
public class Solution
{
    static class Stack 
    {
        int[] arr;
        int size;
        int Counter;
        Stack(int capacity) 
        {
            arr = new int[capacity];
            size = capacity;
            Counter = -1;
        }
        public void push(int num) 
        {
            if(isFull()==0)
            {
                Counter++;
                arr[Counter] = num;
            }
        }
        public int pop() 
        {
            if(isEmpty()==1){return -1;}
            Counter--;
            return arr[Counter+1];
        }
        public int top() 
        {
            if(isEmpty()==1){return -1;}
            return arr[Counter];
        }
        public int isEmpty() 
        {
            if(Counter==-1){return 1;}
            return 0;
        }
        public int isFull() 
        {
            if(Counter==size-1){return 1;}
            return 0;
        }
    }
}
