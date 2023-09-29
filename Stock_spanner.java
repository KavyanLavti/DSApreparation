class StockSpanner 
{
    Stack<Integer> s1;
    int[] arr;
    int counter = 0;

    public StockSpanner() 
    {
        arr = new int[10001];
        s1 = new Stack<>();
    }
    
    public int next(int price) 
    {
        arr[counter] = price;
        while(!s1.isEmpty() && arr[s1.peek()]<=arr[counter])
        {
            s1.pop();
        }
        int j;
        if(s1.isEmpty()){j=-1;}
        else{j=s1.peek();}
        s1.add(counter);
        counter++;
        return counter-j-1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
