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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> arr=new ArrayList<List<Integer>>();
        sum(root,targetSum,new ArrayList<Integer>(),arr);
        return arr;
    }

    public void sum(TreeNode root,int targetSum,List<Integer> sol,List<List<Integer>> arr){
        if(root==null){
            return;
        }
        sol.add(root.val);
        if(root.left==null && root.right==null && targetSum==root.val){
            arr.add(new ArrayList<Integer>(sol));
        }else {
            sum(root.left, targetSum - root.val, sol, arr);
            sum(root.right, targetSum - root.val, sol, arr);
        }
        sol.remove(sol.size()-1);

    }
}
