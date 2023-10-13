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
class Solution {
    boolean flag = true;
    TreeNode previous = null;
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        if(previous!=null && previous.val>=root.val){
            flag = false;
        }
        previous = root;
        traverse(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        return flag;
    }
}
class Solution 
{
    public boolean isValidBST(TreeNode root) 
    {
        boolean xaxa = true;
        if(root==null)return true;
        TreeNode X = root.left;
        TreeNode Y = root.right;
        if(X==null && Y==null)return true;
        else if(X==null)
        {
            while(Y.left!=null)
            {
                Y = Y.left;
            }
            if(Y.val<=root.val)
            {
                xaxa = false;
            }
            return xaxa && isValidBST(root.right);
        }
        else if(Y==null)
        {
            while(X.right!=null)
            {
                X = X.right;
            }
            if(X.val>=root.val)
            {
                xaxa = false;
            }
            return xaxa && isValidBST(root.left);
        }
        else
        {
            while(X.right!=null)
            {
                X = X.right;
            }
            while(Y.left!=null)
            {
                Y = Y.left;
            }
            if(Y.val<=root.val || X.val>=root.val)
            {
                xaxa = false;
            }
            return xaxa && isValidBST(root.left) && isValidBST(root.right);
        }
    }
}
