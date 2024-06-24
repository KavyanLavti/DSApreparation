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


Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.



public class pair
{
    int l;
    TreeNode root;
    pair(TreeNode root, int l)
    {
        this.l=l;
        this.root=root;
    }
}
class Solution 
{
    public int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) 
    {
        if(root==null)return 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        //int cur = -1;
        while(!q.isEmpty())
        {
            pair x = q.poll();
            if(x.root.left==null && x.root.right==null)
            {
                min=Math.min(min,x.l+1);
                break;
            }
            else
            {
                if(x.root.left!=null)q.add(new pair(x.root.left,x.l+1));
                if(x.root.right!=null)q.add(new pair(x.root.right,x.l+1));
            }
        }
        return min;
    }
}
