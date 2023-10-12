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
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        return sex(preorder,0,preorder.length);
    }
    public TreeNode sex(int[] nums, int x, int y)
    {
        if(x>=nums.length)return null;
        TreeNode root = new TreeNode(nums[x]);
        int i = x+1;
        while(i<y && nums[i]<nums[x])
        {
            i++;
        }
        if(y==x+1)
        {
            root.left = null;
            root.right = null;
            return root;
        }
        if(i == y)
        {
            root.right = null;
            root.left = sex(nums,x+1,y);
            return root;
        }
        else if(i == x+1)
        {
            root.left = null;
            root.right = sex(nums,i,y);
            return root;
        }
        else
        {
            root.left = sex(nums,x+1,i);
            root.right = sex(nums,i,y);
            return root;
        }
    }
}
