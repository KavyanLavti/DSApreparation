



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
    private int count = 0;
    private final int MAX_DISTANCE = 10;

    public int countPairs(TreeNode root, int distance) 
    {
        dfs(root, distance);
        return count;
    }

    private int[] dfs(TreeNode node, int distance) 
    {
        if (node == null) return new int[MAX_DISTANCE + 1];
        
        if (node.left == null && node.right == null) 
        {
            int[] res = new int[MAX_DISTANCE + 1];
            res[1] = 1;
            return res;
        }

        int[] left = dfs(node.left, distance);
        int[] right = dfs(node.right, distance);

        for (int i = 1; i <= distance; i++) 
        {
            for (int j = 1; j <= distance - i; j++) 
            {
                count += left[i] * right[j];
            }
        }

        int[] res = new int[MAX_DISTANCE + 1];
        for (int i = 1; i < MAX_DISTANCE; i++) 
        {
            res[i + 1] = left[i] + right[i];
        }

        return res;
    }
}






Intuition:
The problem of counting good leaf node pairs in a binary tree requires us to understand the structure of the tree and efficiently calculate distances between leaf nodes. The key insights that drive our solution are:

Depth-First Search (DFS) Traversal:
We can use a depth-first search approach to traverse the binary tree. This allows us to explore all paths from the root to the leaf nodes efficiently.

Bottom-up Calculation:
Instead of calculating distances from the top down, we can build our solution from the bottom up. This means we start calculations from the leaf nodes and propagate information upwards to their ancestors.

Distance Array:
At each node, we can maintain an array that keeps track of the number of leaf nodes at each distance from that node. This array acts as a summary of the subtree rooted at that node.

Pair Counting:
When we reach a non-leaf node, we have information about leaf nodes in its left and right subtrees. We can use this information to count good pairs without needing to re-traverse the subtrees.

Constant-size Array:
By using a constant-size array (based on the maximum possible distance), we can optimize memory usage and potentially improve cache performance.

Approach:
Define a recursive DFS function that returns an array representing the count of leaf nodes at each distance for the subtree rooted at the current node.

Base cases:

If the node is null, return an empty array.
If the node is a leaf (both left and right children are null), return an array with 1 at index 1 (representing distance 1 from its parent).
Recursive step:

Recursively call the function on the left and right children.
Use the returned arrays to count good pairs:
For each possible pair of distances (i, j) where i is from the left subtree and j is from the right subtree, if i + j + 2 <= distance, count this as a good pair.
Combine the distance information from left and right subtrees:
Shift all distances by 1 (as we're moving one level up in the tree) and sum the counts.
Return the combined distance array for the current subtree.

The main function initiates the recursive call and returns the final count of good pairs.

Time Complexity:
The time complexity of this solution is O(n * d^2), where n is the number of nodes in the tree and d is the given distance.

We visit each node once during the DFS traversal: O(n)
At each non-leaf node, we perform two nested loops, each running up to d times: O(d^2)
The operations inside the loops (array access and arithmetic) are O(1)
Therefore, the overall time complexity is O(n * d^2).

Space Complexity:
The space complexity is O(n * d), where n is the number of nodes and d is the given distance.

The recursion stack can go as deep as the height of the tree, which in the worst case (a skewed tree) can be n. Each recursive call stores an array of size d+1.
We don't create any additional data structures that grow with the input size.
Therefore, the space complexity is O(n * d) in the worst case.

Dry Run:
Let's do a dry run of the algorithm with the following binary tree and distance = 3:

    1
   / \
  2   3
 / \
4   5
We'll represent the process in a tabular form, showing the state at each node as we perform the DFS:

Node	Left Child	Right Child	Distance Array	Good Pairs Count	Notes
4	null	null	[0,1,0,0,0]	0	Leaf node
5	null	null	[0,1,0,0,0]	0	Leaf node
2	4	5	[0,0,2,0,0]	1	1 good pair (4,5)
3	null	null	[0,1,0,0,0]	0	Leaf node
1	2	3	[0,0,1,2,0]	2	1 new good pair (3,4 or 3,5)
Detailed steps:

Node 4 (Leaf):

Returns [0,1,0,0,0] (1 leaf at distance 1 from parent)
No pairs counted
Node 5 (Leaf):

Returns [0,1,0,0,0] (1 leaf at distance 1 from parent)
No pairs counted
Node 2:

Left child (4) returned [0,1,0,0,0]
Right child (5) returned [0,1,0,0,0]
Counts pairs: 1 * 1 = 1 pair (distance 1 + 1 + 2 = 4, which is > 3, so not counted)
Combines and shifts distances: [0,0,2,0,0] (2 leaves at distance 2 from parent)
Good pairs count: 1
Node 3 (Leaf):

Returns [0,1,0,0,0] (1 leaf at distance 1 from parent)
No pairs counted
Node 1 (Root):

Left child (2) returned [0,0,2,0,0]
Right child (3) returned [0,1,0,0,0]
Counts pairs:
2 * 1 = 2 pairs (distance 2 + 1 + 2 = 5, which is > 3, so not counted)
0 * 1 = 0 pairs (for other combinations)
Combines and shifts distances: [0,0,1,2,0]
(1 leaf at distance 2, 2 leaves at distance 3 from root)
Good pairs count: 1 + 2 = 3
Final result: 3 good pairs ((4,5), (3,4), (3,5))

This dry run illustrates how the algorithm traverses the tree, counts good pairs at each non-leaf node, and combines distance information as it moves up the tree. The final result correctly identifies all good leaf pairs within the given distance.

The approach efficiently solves the problem by:

Avoiding redundant calculations by summarizing subtree information.
Counting pairs without explicitly finding all paths between leaves.
Propagating distance information up the tree to enable efficient pair counting at higher levels.
This method balances time and space efficiency, making it suitable for trees of various sizes and structures. The use of a constant-size array (based on the maximum possible distance) helps in optimizing memory usage and potentially improving cache performance, which can lead to faster execution times in practice.
