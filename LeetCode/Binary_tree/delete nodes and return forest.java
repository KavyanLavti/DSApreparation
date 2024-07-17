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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        List<TreeNode> parent = new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        List<Character> arr = new ArrayList<>();
        List<Integer> nunnu = new ArrayList<>();
        for(int x : to_delete){nunnu.add(x);}
        for(int x : to_delete)
        {
            List<TreeNode> l1 = parentAndroot(root,x,null);
            if(l1.get(0)!=null)
            {
                parent.add(l1.get(0));
                if(l1.get(0).left==l1.get(1))arr.add('L');
                else arr.add('R');
            }
            if(l1.get(1)!=null)
            {
                if(l1.get(1).left!=null && !nunnu.contains(l1.get(1).left.val))ans.add(l1.get(1).left);
                if(l1.get(1).right!=null && !nunnu.contains(l1.get(1).right.val))ans.add(l1.get(1).right);
            }
        }
        for(int i=0; i<parent.size(); i++)
        {
            if(arr.get(i)=='L')parent.get(i).left=null;
            else parent.get(i).right=null;
        }
        if(!nunnu.contains(root.val))ans.add(root);
        return ans;
    }
    public List<TreeNode> parentAndroot(TreeNode root, int x, TreeNode parent)
    {
        List<TreeNode> l1 = new ArrayList<>();
        if(root==null)return l1;
        if(root.val==x)
        {
            l1.add(parent);
            l1.add(root);
            return l1;
        }
        l1.addAll(parentAndroot(root.left,x,root));
        l1.addAll(parentAndroot(root.right,x,root));
        return l1;
    }
}
//BTETTER SOLUTION

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toBeDeleteNodes = new HashSet<>();
        List<TreeNode> result = new ArrayList<>();
        if(root==null)
            return result;
        for(int i: to_delete){
            toBeDeleteNodes.add(i);
        }
        delete(root, toBeDeleteNodes, result);
        if(!toBeDeleteNodes.contains(root.val))
            result.add(root);
        return result;
    }

    private TreeNode delete(TreeNode root, Set<Integer> toBeDeleteNodes, List<TreeNode> result){
        if(root==null)
            return null;
        root.left = delete(root.left, toBeDeleteNodes, result);
        root.right = delete(root.right, toBeDeleteNodes, result);
        if(toBeDeleteNodes.contains(root.val)){
            if(root.left!=null)
                result.add(root.left);
            if(root.right!=null)
                result.add(root.right);
            return null;
        }
        return root;
    }
}
