/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/



Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.






class pair
{
    int level;
    Node root;
    public pair(Node root, int level)
    {
        this.root=root;
        this.level=level;
    }
}
class Solution 
{
    int l = 0;
    public Node connect(Node root) 
    {
        if(root==null)return null;
        Queue<pair> q = new LinkedList<>();
        pair prev = null;
        q.add(new pair(root,0));
        while(!q.isEmpty())
        {
            pair x = q.poll();
            if(l!=x.level)
            {
                prev.root.next = null;
                l=x.level;
            }
            else if(prev!=null)
            {
                prev.root.next = x.root;
            }
            prev = x;
            if(x.root.left!=null)q.add(new pair(x.root.left,x.level+1));
            if(x.root.right!=null)q.add(new pair(x.root.right,x.level+1));
        }
        prev.root.next = null;
        return root;
    }
}
