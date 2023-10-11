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
    public void flatten(TreeNode root) 
    {
        if(root==null)return;
        TreeNode r = root.right;
        TreeNode pre = root.left;
        TreeNode l = pre;
        while(pre!=null && pre.right!=null)
        {
            pre = pre.right;
        }
        if(pre!=null)
        {
            pre.right = r;
            root.right = l;
            root.left = null;
        }
        flatten(root.right);
    }
}
