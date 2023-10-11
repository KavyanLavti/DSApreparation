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
// class pair
// {
//     int level;
//     Node root;
//     pair(int level, Node root)
//     {
//         this.level = level;
//         this.root = root;
//     }
// }
class Solution 
{
    public Node connect(Node root) 
    {
        if(root==null)return null;
        Node leftMost = root;
        while(leftMost.left!=null)
        {
            Node cur = leftMost;
            while(cur!=null)
            {
                cur.left.next = cur.right;
                if(cur.next!=null)
                {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            leftMost = leftMost.left;
        }
        // Queue<pair> q1 = new LinkedList<>();
        // pair pre = new pair(0,root);
        // q1.add(pre);
        // while(!q1.isEmpty())
        // {
        //     pair x = q1.poll();
        //     if(x.level!=pre.level||x==pre)
        //     {
        //         pre.root.next = null;
        //     }
        //     else
        //     {
        //         pre.root.next = x.root;
        //     }
        //     pre = x;
        //     if(x.root.left!=null)
        //     {
        //         q1.add(new pair(x.level+1,x.root.left));
        //     }
        //     if(x.root.right!=null)
        //     {
        //         q1.add(new pair(x.level+1,x.root.right));
        //     }
        // }
        return root;
    }
}
