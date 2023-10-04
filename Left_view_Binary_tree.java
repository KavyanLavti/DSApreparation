import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> zaba = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        leftView(root, 0, l1, zaba);
        return zaba;
    }
    public static void leftView(TreeNode<Integer> root, int level, List<Integer> sup, ArrayList<Integer> zexy)
    {
        if(root == null) return;
        //List<Integer> sup = new ArrayList<Integer>(ds);
        TreeNode X = root;
        if(!sup.contains(level))
        {
            zexy.add(root.data);
            sup.add(level);
        }
        leftView(X.left, level+1, sup, zexy);
        leftView(X.right, level+1, sup, zexy);
    }
}
