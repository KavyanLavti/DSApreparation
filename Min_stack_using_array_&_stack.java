class MinStack 
{
    int[] arr;
    Stack<Integer> s1;
    int pointer = -1;

    public MinStack() 
    {
        arr = new int[10001];
        s1 = new Stack<>();   
    }
    public void push(int val) 
    {
        pointer++;
        arr[pointer] = val;
        if(s1.isEmpty() || arr[s1.peek()]>val)
        {
            s1.push(pointer);
        }
        return;
    }
    public void pop() 
    {
        if(s1.peek()==pointer)
        {
            s1.pop();
        }
        pointer--;
        return;
    }
    public int top() 
    {
        return arr[pointer];
    }
    public int getMin() 
    {
        return arr[s1.peek()];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
