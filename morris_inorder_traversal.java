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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> l1 = new ArrayList<Integer>();
        TreeNode X = root;
        while(X!=null)
        {
            if(X.left == null)
            {
                l1.add(X.val);
                X=X.right;
            }
            else
            {
                TreeNode Y = X.left;
                while(Y.right!=null && Y.right!=X)
                {
                    Y=Y.right;
                }
                if(Y.right==null)
                {
                    Y.right = X;
                    X = X.left;
                }
                else
                {
                    Y.right=null;
                    l1.add(X.val);
                    X=X.right;
                }
            }
        }
        return l1;
    }
}
