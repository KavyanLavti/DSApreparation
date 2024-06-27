There is an undirected star graph consisting of n nodes labeled from 1 to n. 
A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center 
node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that 
there is an edge between the nodes ui and vi. Return the center of the given star graph.







class Solution 
{
    public int findCenter(int[][] edges) 
    {
        int x = edges[0][0];
        int y = edges[0][1];

        if(edges[1][0]==x||edges[1][0]==y)return edges[1][0];
        return edges[1][1];
        // HashMap<Integer,Integer> h = new HashMap<>();
        // for(int[] ed:edges)
        // {
        //     put(ed[0],h);
        //     put(ed[1],h);
        // }
        // for(Map.Entry<Integer,Integer> set : h.entrySet())
        // {
        //     if(set.getValue()==edges.length)return set.getKey();
        // }
        // return -1;
    }
    public void put(int i, HashMap<Integer,Integer> h)
    {
        if(h.containsKey(i))h.put(i,h.get(i)+1);
        else h.put(i,1);
    }
}
