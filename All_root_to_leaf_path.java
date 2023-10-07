/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) 
    {
        List<String> l1 = new ArrayList<>();
        String ja = "";
        lamda(root,l1,ja);
        return l1;
    }
    public static void lamda(BinaryTreeNode root, List<String> ans, String sup)
    {
        if(root==null)
        {
            return;
        }
        String s = sup;
        s += Integer.toString(root.data);
        s += ' ';
        if(root.left==null && root.right==null)
        {
            ans.add(s);
            return;
        }
        lamda(root.left,ans,s);
        lamda(root.right,ans,s);
        s = s.substring(0,s.length()-2);
    }
}
