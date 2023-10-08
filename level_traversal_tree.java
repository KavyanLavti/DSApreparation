/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class pair
{
    int level;
    TreeNode root;
    pair(int level, TreeNode root)
    {
        this.level = level;
        this.root = root;
    }
}
class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        Queue<pair> q1 = new LinkedList<>();
        List<List<Integer>> fs = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        if(root==null)return fs;
        fs.add(l1);
        pair pre = new pair(0,root);
        q1.add(pre);
        while(!q1.isEmpty())
        {
            pair p1 = q1.poll();
            if(pre.level == p1.level)
            {
                fs.get(fs.size()-1).add(p1.root.val);
            }
            else
            {
                List<Integer> l2 = new ArrayList<Integer>();
                l2.add(p1.root.val);
                fs.add(l2);
            }
            pre=p1;
            if(p1.root.left!=null)
            {
                q1.add(new pair(p1.level+1,p1.root.left));
            }
            if(p1.root.right!=null)
            {
                q1.add(new pair(p1.level+1,p1.root.right));
            }
        }
        return fs;
    }
}
