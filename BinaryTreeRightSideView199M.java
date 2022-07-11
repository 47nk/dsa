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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        //each levels last element in level order transversal is part of right side view
        //O(V+E);
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i<size; i++)
            {
                TreeNode currentNode = queue.poll();
                if(i == size-1) ans.add(currentNode.val);
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return ans;
    }
}
