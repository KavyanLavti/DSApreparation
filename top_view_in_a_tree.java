public class Solution 
{
    static int min = 0, max = 0;
    public static List<Integer> getTopView(TreeNode root) 
    {
        HashMap<Integer, List<Integer>> h = new HashMap<>();
        //HashMap<Integer, Integer> p = new HashMap<>();
        butt(root, h, 0, 0);
        List<Integer> l1 = new ArrayList<>();
        for(int i = min; i<=max; i++)
        {
            l1.add(h.get(i).get(1));
        }
        return l1;
    }
    public static void butt(TreeNode root, HashMap<Integer,List<Integer>> h, int level, int dist)
    {
        if(root==null) return;
        if(!h.containsKey(dist))
        {
            List l1 = new ArrayList<>();
            l1.add(level);
            l1.add(root.data);
            h.put(dist, l1);
        }
        else
        {
            if(level<(h.get(dist)).get(0))
            {
                h.get(dist).set(0,level);
                h.get(dist).set(1, root.data);
            }
        }
        min = Math.min(min, dist);
        max = Math.max(max, dist);
        butt(root.left, h, level+1, dist-1);
        butt(root.right, h, level+1, dist+1);
    }
}
