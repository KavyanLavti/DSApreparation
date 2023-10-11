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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        if(root==null)return max;
        int z = maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode root)
    {
        if(root.left==null&&root.right==null)
        {
            return 0;
        }
        else if(root.left==null)
        {
            int r = maxDepth(root.right);
            max = Math.max(max,r+1);
            return r+1;
        }
        else if(root.right==null)
        {
            int l = maxDepth(root.left);
            max = Math.max(max,l+1);
            return l+1;
        }
        else
        {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            max = Math.max(max,l+r+2);
            return Math.max(l+1,r+1);
        }
    }
}
