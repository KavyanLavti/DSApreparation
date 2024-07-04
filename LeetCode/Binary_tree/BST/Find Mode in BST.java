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
    public int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) 
    {
        HashMap<Integer,Integer> h = new HashMap<>();
        mama(root,h);
        return ans(h,max);
    }
    public void mama(TreeNode root, HashMap<Integer,Integer> h)
    {
        if(root==null)return;
        if(h.containsKey(root.val))h.put(root.val,h.get(root.val)+1);
        else h.put(root.val,1);
        max = Math.max(max,h.get(root.val));
        mama(root.left,h);
        mama(root.right,h);
    }
    public int[] ans(HashMap<Integer,Integer> h, int max)
    {
        List<Integer> l1 = new ArrayList<>();
        for(Map.Entry<Integer,Integer> s : h.entrySet())
        {
            if(s.getValue()==max)l1.add(s.getKey());
        }
        int[] A = new int[l1.size()];
        for(int i=0; i<l1.size(); i++)
        {
            A[i] = l1.get(i);
        }
        return A;
    }
}

// READ THIS REALLY GOOD LOGIC AND TRAVERSAL THROUGH BST


BETTER CODE FOR BST

private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
}
