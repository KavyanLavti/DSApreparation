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
class pair
{
    int level;
    TreeNode root;
    pair(int level, TreeNode root)
    {
        this.level = level;
        this.root = root;
    }
}
class Solution 
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> fs = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        Queue<pair> q1 = new LinkedList<>();
        if(root==null)return fs;
        fs.add(l1);
        pair pre = new pair(0,root);
        q1.add(pre);
        while(!q1.isEmpty())
        {
            pair x = q1.poll();
            if(x.level==pre.level)
            {
                fs.get(fs.size()-1).add(x.root.val);
            }
            else
            {
                List<Integer> l2 = new ArrayList<>();
                l2.add(x.root.val);
                fs.add(l2);
            }
            if(x.root.left!=null){q1.add(new pair(x.level+1,x.root.left));}
            if(x.root.right!=null){q1.add(new pair(x.level+1,x.root.right));}
            pre = x;
        }
        int i =1;
        int n = fs.size();
        while(i<n)
        {
            rotateList(fs.get(i));
            i=i+2;
        }
        return fs;
    }
    public void rotateList(List<Integer> l1)
    {
        int i = 0;
        int n = l1.size();
        while(i<=(n-1)/2)
        {
            int temp = l1.get(i);
            l1.set(i,l1.get(n-1-i));
            l1.set(n-1-i,temp);
            i++;
        }
    }
}
