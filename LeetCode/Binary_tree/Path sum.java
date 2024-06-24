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



Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.




class Solution 
{
    public boolean hasPathSum(TreeNode root, int targetSum) 
    {
        if(root==null)return false;
        //boolean ans = false;
        //System.out.println(targetSum);
        if(root.left==null && root.right==null)
        {
            if(targetSum==root.val)return true;
            return false;
        }
        else if(root.right==null)
        {
            return hasPathSum(root.left,targetSum-root.val);
        }
        else if(root.left==null)
        {
            return hasPathSum(root.right,targetSum-root.val);
        }
        else
        {
            return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
        }
    }
}
