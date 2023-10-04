import java.util.* ;
import java.io.*; 
/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/

public class Solution 
{
    public static List < Integer > getPreOrderTraversal(TreeNode root) 
	  {
    	  List<Integer> l1 = new ArrayList<Integer>();
        TreeNode X = root;
        while(X!=null)
        {
            if(X.left == null)
            {
				        l1.add(X.data);
                X=X.right;
            }
            else
            {
                TreeNode Y = X.left;
                while(Y.right!=null && Y.right!=X)
                {
                    Y=Y.right;
                }
                if(Y.right==null)
                {
					          l1.add(X.data);
                    Y.right = X;
                    X = X.left;
                }
                else
                {
                    Y.right=null;
                    X=X.right;
                }
            }
        }
        return l1;
    }
}
