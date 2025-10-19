// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode leftMost = dfs(node.left);
        TreeNode rightMost = dfs(node.right);

        if (leftMost != null) {
            leftMost.right = node.right;
            node.right = node.left;
            node.left = null;
        }


        if (rightMost == null) {
            return leftMost;
        } else {
            return rightMost;
        }

    }
}