/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution 
{
    public static boolean isParentSum(Node root) 
    {
        if(root == null)
        {
            return true;
        }
        else
        {
            int s = sumofChildren(root);
            return(((s==0)||s==root.data) && isParentSum(root.left) && isParentSum(root.right));
        }
    }
    public static int sumofChildren(Node root)
    {
        if(root.left == null && root.right == null)
        {
            return 0;
        }
        else if(root.left == null)
        {
            return root.right.data;
        }
        else if(root.right == null)
        {
            return root.left.data;
        }
        else
        {
            return root.right.data + root.left.data;
        }
    }
}
