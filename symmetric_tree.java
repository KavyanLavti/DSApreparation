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
class Solution 
{
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null)return true;
        return mirrorTree(root.left,root.right);
    }
    public boolean mirrorTree(TreeNode p, TreeNode q)
    {
        if(p==null&&q==null)return true;
        else if(p==null||q==null)return false;
        else return ((p.val==q.val)&&mirrorTree(p.left,q.right)&&mirrorTree(p.right,q.left));
    }
}
