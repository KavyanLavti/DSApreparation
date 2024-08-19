class Solution 
{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        boolean[] vis = new boolean[rooms.size()];
        lala(rooms,0,vis);
        for(int i=0; i<vis.length; i++)
        {
            if(!vis[i])return false;
        }
        return true;
    }
    public void lala(List<List<Integer>> fs, int i, boolean[] vis)
    {
        List<Integer> l1= fs.get(i);
        vis[i] = true;
        for(int k=0; k<l1.size(); k++)
        {
            if(!vis[l1.get(k)])lala(fs,l1.get(k),vis);
        }
        return;
    }
}
