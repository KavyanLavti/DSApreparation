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
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> l1 = new ArrayList<>();
        if(root == null)
        {
            return l1;
        }
        l1.addAll(postorderTraversal(root.left));
        l1.addAll(postorderTraversal(root.right));
        l1.add(root.val);
        return l1;
    }
}
