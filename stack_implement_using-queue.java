class MyStack 
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    //Queue<Integer> q2 = new LinkedList<Integer>();

    public MyStack() 
    {

    }
    
    public void push(int x) 
    {
        q1.add(x);
        int l = q1.size()-1;
        for(int i=0; i<l; i++)
        {
            int p = q1.remove();
            q1.add(p);
        }
        return;  
    }
    
    public int pop() 
    {
        return q1.remove();
    }
    
    public int top() 
    {
        int ans = q1.remove();
        q1.add(ans);
        int l = q1.size()-1;
        for(int i=0; i<l; i++)
        {
            int x = q1.remove();
            q1.add(x);
        }
        return ans;
    }
    
    public boolean empty() 
    {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
