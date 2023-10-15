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

public class Solution 
{

    public static int floorInBST(TreeNode<Integer> root, int X) 
    {
        int pre = -1;
        while(root!=null)
        {
            if(root.data>X)
            {
                root = root.left;
            }
            else
            {
                pre = root.data;
                root = root.right;
            }
        }
        return pre;
    }
}
