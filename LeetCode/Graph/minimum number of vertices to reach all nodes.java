class Solution 
{
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) 
    {
        List<Integer> l1 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        //IF I USE FREQUENCY/BOOLEAN ARRAY INSTEAD OF SET THE TIME REDUCES TO 8ms INSTEAD OF 22ms
        //SIZE OF THE ARRAY WOULD BE N

        for(int i=0; i<edges.size(); i++)
        {   
            set.add(edges.get(i).get(1));
        }
        for(int i=0; i<n; i++)
        {
            if(!set.contains(i))l1.add(i);
        }
        return l1;
    }
}
