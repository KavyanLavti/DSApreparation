/************************************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }


 ************************************************************/
 import java.util.*;
class pair3
{
    int dist;
    int level;
    TreeNode root;
    pair3(int dist, int level, TreeNode root)
    {
        this.dist = dist;
        this.level = level;
        this.root = root;
    }
}
public class Solution 
{
    public static int getMaxWidth(TreeNode root) 
    {
        //HashMap<Integer, List<Integer>> h = new HashMap<>();
        //ArrayList<Integer> fs = new ArrayList<Integer>();
        if(root==null)return 0;
        int max=0;
        int curMax=0;
        Queue<pair3> q1 = new LinkedList<>();
        pair3 previous = new pair3(0,0,root);
        q1.add(previous);
        while(!q1.isEmpty())
        {
            pair3 x = q1.poll();
            if(x.level!=previous.level)
            {
                max= Math.max(max,curMax);
                curMax=0;
            }
            curMax++;
            if(x.root.left!=null)
            {
                q1.add(new pair3(x.dist-1, x.level+1, x.root.left));
            }
            if(x.root.right!=null)
            {
                q1.add(new pair3(x.dist+1, x.level+1, x.root.right));
            }
            previous = x;
        }
        max= Math.max(max,curMax);
        return max;
    }
}
