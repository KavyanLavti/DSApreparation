/*********************************************

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

 *********************************************/

import java.util.*;
class pair
{
    int dist;
    TreeNode X;
    pair(int dist, TreeNode L)
    {
        this.dist = dist;
        this.X = L;
    }
}
public class Solution 
{
    //static int min = 0, max = 0;
    public static List<Integer> bottomView(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        int min = 0; 
        int max = 0;
        Queue<pair> q1 = new LinkedList<>();
        HashMap<Integer,TreeNode> h = new HashMap<>();
        pair p = new pair(0, root);
        q1.add(p);
        while(!q1.isEmpty())
        {
            pair x = q1.poll();
            min = Math.min(min, x.dist);
            max = Math.max(max, x.dist);
            h.put(x.dist, x.X);
            if(x.X.left!=null)
            {
                q1.add(new pair(x.dist-1, x.X.left));
            }
            if(x.X.right!=null)
            {
                q1.add(new pair(x.dist+1,x.X.right));
            }
        }
        for(int i=min; i<=max; i++)
        {
            ans.add(h.get(i).val);
        }
        return ans;
    }
}
