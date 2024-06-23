Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.



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
    public int sumOfLeftLeaves(TreeNode root) 
    {
        return sml(root,false);
    }
    public int sml(TreeNode root, boolean left)
    {
        if(root==null)return 0;
        else if(!left)
        {
            if(root.left==null && root.right==null)return 0;
            else if(root.left==null)return sml(root.right,false);
            else if(root.right==null)return sml(root.left,true);
            else return sml(root.right,false)+sml(root.left,true);
        }
        else
        {
            if(root.left==null && root.right==null)return root.val;
            else if(root.left==null)return sml(root.right,false);
            else if(root.right==null)return sml(root.left,true);
            else return sml(root.right,false)+sml(root.left,true);
        }
    }
}
