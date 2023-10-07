import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

class pair3
{
    int dist;
    int level;
    TreeNode<Integer> root;
    pair3(int dist, int level, TreeNode<Integer> root)
    {
        this.dist = dist;
        this.level = level;
        this.root = root;
    }
}
public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        HashMap<Integer, List<Integer>> h = new HashMap<>();
        ArrayList<Integer> fs = new ArrayList<Integer>();
        int min=0,max=0;
        Queue<pair3> q1 = new LinkedList<>();
        pair3 previous = new pair3(0,0,root);
        q1.add(previous);
        while(!q1.isEmpty())
        {
            pair3 x = q1.poll();
            if(h.containsKey(x.dist))
            {
                List<Integer> l1 = h.get(x.dist);
                l1.add(x.root.data); 
                h.put(x.dist,l1);
            }
            else
            {
                List<Integer> l1 = new ArrayList<>();
                l1.add(x.root.data);
                h.put(x.dist,l1);
            }
            if(x.root.left!=null)
            {
                q1.add(new pair3(x.dist-1, x.level+1, x.root.left));
            }
            if(x.root.right!=null)
            {
                q1.add(new pair3(x.dist+1, x.level+1, x.root.right));
            }
            min = Math.min(min,x.dist);
            max = Math.max(max,x.dist);
            previous = x;
        }
        for(int i=min; i<=max; i++)
        {
            fs.addAll(h.get(i));
        }
        return fs;
    }
}
