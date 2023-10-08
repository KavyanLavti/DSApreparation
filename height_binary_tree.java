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
    public int maxDepth(TreeNode root) 
    {
        if(root==null)return 0;
        traverse(root,0);
        return max+1;
    }
    public void traverse(TreeNode root, int level)
    {
        if(root==null)
        {
            return;
        }
        max = Math.max(max,level);
        traverse(root.left ,level+1);
        traverse(root.right, level+1);
    }
}
