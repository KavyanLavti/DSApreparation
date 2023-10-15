/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;

//import com.sun.tools.classfile.Annotation.element_value;
public class Solution 
{
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) 
    {
        List<Integer> ans = new ArrayList<Integer>();
        int suc = -1;
        int pre = -1;
        TreeNode X = root;
        TreeNode Y = root;
        while(X!=null)
        {
            if(X.data<=key)
            {
                X= X.right;
            }
            else
            {
                suc = X.data;
                X = X.left;
            }
        }
        while(Y!=null)
        {
            if(Y.data>=key)
            {
                Y=Y.left;
            }
            else
            {
                pre = Y.data;
                Y = Y.right;
            }
        }
        ans.add(pre);
        ans.add(suc);
        return ans;
    }
}
