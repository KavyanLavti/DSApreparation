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
class BSTIterator 
{
    TreeNode fucking;
    TreeNode lul;
    public BSTIterator(TreeNode root) 
    {
        fucking = root;
        lul = null;
    }   
    public int next() 
    {
        int z = -3;
        while(fucking!=null && z<0)
        {
            if(fucking.left==null)
            {
                z=fucking.val;
                lul=fucking;
                fucking = fucking.right;
            }
            else
            {
                TreeNode pre = fucking.left;
                while(pre.right!=null && pre.right!=fucking)pre=pre.right;
                if(pre.right==null)
                {
                    pre.right = fucking;
                    lul=fucking;
                    fucking = fucking.left;
                }
                else
                {
                    pre.right = null;
                    z=fucking.val;
                    lul=fucking;
                    fucking = fucking.right;
                }
            }
        }
        return z;
    }   
    public boolean hasNext() 
    {
        if(lul == null) return true;
        if(lul.right==null)return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
