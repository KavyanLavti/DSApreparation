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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        if(root==null)return 0;
        int z = maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int l = maxSum(root.left);
        int r = maxSum(root.right);
        if(l<=0 && r<=0)
        {
            max=Math.max(max,root.val);
            return root.val;
        }
        else if(l<=0)
        {
            max=Math.max(max,r+root.val);
            return r+root.val;
        }
        else if(r<=0)
        {
            max=Math.max(max,l+root.val);
            return l+root.val;
        }
        else
        {
            max=Math.max(max,l+r+root.val);
            return Math.max(l,r)+root.val;
        }
        // if(root.left==null && root.right==null)
        // {
        //     max=Math.max(max,root.val);
        //     return root.val;
        // }
        // else if(root.left==null)
        // {
        //     int r = maxSum(root.right)+root.val;
        //     max = Math.max(r,max);
        //     return r;
        // }
        // else if(root.right==null)
        // {
        //     int l = maxSum(root.left)+root.val;
        //     max = Math.max(l,max);
        //     return l;
        // }
        // else
        // {
        //     int l = maxSum(root.left);
        //     int r = maxSum(root.right);
        //     max = Math.max(max,l+r+root.val);
        //     return Math.max(l,r)+root.val;
        // }
    }
}
