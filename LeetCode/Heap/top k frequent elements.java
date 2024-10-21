class Solution 
{
    //RATHER THEN USING MIN HEAP WE COULD PUT -VE VALUES OF FREQUENCY IN PRIORITY QUEUE SO THE FIRST K ELEMENTS TO POP WILL BE 
    //THE K MOST FREQUENT ELEMENTS AND WE WONT NEED h2 IN THAT SOLUTION
    public int[] topKFrequent(int[] nums, int k) 
    {
        int[] ans =  new int[k];
        HashMap<Integer,Integer> h = new HashMap<>();
        HashMap<Integer,List<Integer>> h2 = new HashMap<>();
        for(int x:nums)
        {
            h.put(x,h.getOrDefault(x,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> sp : h.entrySet())
        {
            pq.add(sp.getValue());
            if(pq.size()>k)pq.poll();
            if(h2.containsKey(sp.getValue()))
            {
                h2.get(sp.getValue()).add(sp.getKey());
            }
            else
            {
                h2.put(sp.getValue(),new ArrayList<Integer>());
                h2.get(sp.getValue()).add(sp.getKey());
            }
        }
        int i=0;
        while(!pq.isEmpty())
        {
            int x = pq.poll();
            List<Integer> l1 = h2.get(x);
            while(!pq.isEmpty() && x==pq.peek())pq.poll();
            for(int j=0; j<l1.size(); j++)
            {
                ans[i]=l1.get(j);
                i++;
            }         
        }
        return ans;
    }
}
