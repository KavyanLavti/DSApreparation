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
    public int sumNumbers(TreeNode root) 
    {
        List<Integer> l1 = new ArrayList<>();
        sexa(root,0,l1);
        int sum = 0;
        for(int A:l1)
        {
            sum=sum+A;
        }
        return sum;
    }
    public void sexa(TreeNode root, int value, List<Integer> sum)
    {
        if(root==null)return;
        value = value*10+root.val;
        if(root.right==null&&root.left==null)
        {
            sum.add(value);
            //System.out.println(sum);
        }
        else
        {
            sexa(root.left,value,sum);
            sexa(root.right,value,sum);
        }
        value = value/10;
    }
}
