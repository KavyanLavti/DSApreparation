Given the root of a binary tree, return the bottom-up level order traversal of its nodes
values. (i.e., from left to right, level by level from leaf to root).



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
public class level
{
    int l;
    TreeNode root;
    level(TreeNode root, int l)
    {
        this.root=root;
        this.l=l;
    }
}
class Solution 
{
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<level> q = new LinkedList<>();
        q.add(new level(root,0));
        int cur = -1;
        while(!q.isEmpty())
        {
            level x = q.poll();
            if(cur == x.l)
            {
                ans.get(ans.size()-1).add(x.root.val);
            }
            else
            {
                List<Integer> l1 = new ArrayList<>();
                l1.add(x.root.val);
                ans.add(l1);
                cur=x.l;
            }
            if(x.root.left!=null)q.add(new level(x.root.left,x.l+1));
            if(x.root.right!=null)q.add(new level(x.root.right,x.l+1));
        }
        return swap(ans);
    }
    public List<List<Integer>> swap(List<List<Integer>> ans)
    {
        int n = ans.size();
        for(int i=0; i<n/2; i++)
        {
            List<Integer> l1 = ans.get(i);
            ans.set(i,ans.get(n-1-i));
            ans.set(n-1-i,l1);
        }
        return ans;
    }
}
