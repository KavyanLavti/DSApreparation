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



Given an integer n, return all the structurally unique BSTs 
(binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.


NOTE:- the DP is not applied in this solution but to apply it as we have two parameters of DP
n and low, we can make a hashmap of strings and list of treenodes where the key would be the 
String low+"_"+n

class Solution 
{
    public List<TreeNode> generateTrees(int n) 
    {
        return ratfucker(n,1);
    }
    public List<TreeNode> ratfucker(int n, int low)
    {
        List<TreeNode> ans = new ArrayList<>();
        if(n==1)
        {
            ans.add(new TreeNode(low));
            return ans;
        }
        for(int i=0; i<n; i++)
        {
            List<TreeNode> left = ratfucker(i,low);
            List<TreeNode> right = ratfucker(n-1-i,low+i+1);

            if(left.isEmpty())
            {
                for(TreeNode r : right)
                {
                    TreeNode t = new TreeNode(low+i);
                    t.left = null;
                    t.right = r;
                    ans.add(t);
                }
            }
            else if(right.isEmpty())
            {
                for(TreeNode l : left)
                {
                    TreeNode t = new TreeNode(low+i);
                    t.left = l;
                    t.right = null;
                    ans.add(t);
                }
            }
            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode t = new TreeNode(low+i);
                    t.left = l;
                    t.right = r;
                    ans.add(t);
                }
            }
        }

        return ans;
    }
}
