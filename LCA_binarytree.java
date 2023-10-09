/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root==null||root==p||root==q)
        {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null)return right;
        else if(right==null)return left;
        else return root;
        // List<List<TreeNode>> fs = new ArrayList<List<TreeNode>>();
        // bs(root,p,q,new ArrayList<TreeNode>(),fs);
        // List<TreeNode> l1 = fs.get(0);
        // List<TreeNode> l2 = fs.get(1);
        // int i= Math.min(l1.size(),l2.size())-1;
        // while(l1.get(i)!=l2.get(i))
        // {
        //     i--;
        // }
        // return l1.get(i);
    }
    // public void bs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> ds, List<List<TreeNode>> fs)
    // {
    //     if(root==null)return;
    //     List<TreeNode> sup = new ArrayList<TreeNode>(ds);
    //     sup.add(root);
    //     if(root==p||root==q){fs.add(sup);}
    //     bs(root.left,p,q,sup,fs);
    //     bs(root.right,p,q,sup,fs);
    //     return;
    // }
}
