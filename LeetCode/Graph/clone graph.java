/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/



Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}






class Solution 
{
    public Node cloneGraph(Node node) 
    {
        HashMap<Node,Node> h = new HashMap<>();
        return CG(node,h);
    }
    public Node CG(Node node, HashMap<Node,Node> vis)
    {
        if(node==null)return null;
        if(vis.containsKey(node))return vis.get(node);
        Node clone = new Node(node.val);
        vis.put(node,clone);
        for(Node n : node.neighbors)
        {
            clone.neighbors.add(CG(n,vis));
        }
        return clone;
    }
}
