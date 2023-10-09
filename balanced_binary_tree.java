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
    boolean sex = true;
    public boolean isBalanced(TreeNode root) 
    {
        int z = someFn(root,0);
        return sex;
    }
    public int someFn(TreeNode root, int level)
    {
        if(root==null)
        {
            return 0;
        }
        int l = someFn(root.left,level+1);
        int r = someFn(root.right,level+1);
        if(Math.abs(l-r)>1){sex=false;}
        return Math.max(l,r)+1;  
    }
}
