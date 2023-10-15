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

//  SOLVED THROUGH MORRIS TRAVERSAL O(K)

class Solution 
{
    public int kthSmallest(TreeNode root, int k) 
    {
        int n = 0;
        TreeNode pres = root;
        while(root!=null)
        {
            if(n==k)break;
            if(root.left==null)
            {
                n++;
                pres = root; 
                root = root.right;
            }
            else
            {
                TreeNode pre = root.left;
                while(pre.right!=null && pre.right!=root)
                {
                    pre = pre.right;
                }
                if(pre.right==null)
                {
                    pre.right = root;
                    pres = root;
                    root = root.left;
                }
                else
                {
                    pre.right = null;
                    pres = root;
                    root = root.right;
                    n++;
                }
            }
        }
        return pres.val;
    }
}
