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



Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

 





class Solution 
{
    public int lav;
    public List<TreeNode> allPossibleFBT(int n) 
    {
        // if(n%2==0)return null;
        // lav = n;
        // List<TreeNode> l1 = new ArrayList<>();
        // TreeNode x = new TreeNode(0);
        // gaand(n,l1,x);
        // return l1;
        if(n%2==0)return new ArrayList<TreeNode>();
        HashMap<Integer,List<TreeNode>> h = new HashMap<>();
        return assLicker(n,h);
    }
    public List<TreeNode> assLicker(int n, HashMap<Integer,List<TreeNode>> h)
    {
        List<TreeNode> ans = new ArrayList<>();
        if(n==1)
        {
            ans.add(new TreeNode(0));
            return ans;
        }
        if(h.containsKey(n))return h.get(n);
        for(int i=1; i<n-1; i+=2)
        {
            List<TreeNode> left = assLicker(i,h);
            List<TreeNode> right = assLicker(n-1-i,h);

            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode t = new TreeNode(0);
                    t.left = l;
                    t.right = r;
                    ans.add(t);
                }
            }
        }
        h.put(n,ans);
        return ans;
    }
    // public TreeNode gaand(int n, List<TreeNode> l1, TreeNode t)
    // {
    //     if(n==0)
    //     {
    //         return null;
    //     }
    //     TreeNode x = new TreeNode(0);
    //     // TreeNode t2 = new TreeNode(0);
    //     for(int i=1; i<n-1; i+=2)
    //     {
    //         x.left = gaand(i,l1,t);
    //         x.right = gaand(n-1-i,l1,t);
    //         if(n==lav)
    //         {
    //             t=x;
    //             l1.add(t);
    //         }
    //     }
    //     return x;
    // }
    // && ((x.left!=null&&x.right!=null)||(x.left==null&&x.right==null))
}
