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
    int max = 0;
    
    public int maxDepth(TreeNode root) {
        // 최대 깊이 구하기 dfs로 구하면 되지 않을까
        dfs(root, 1);

        return max;
    }
    public void dfs(TreeNode cur, int level) {
        if (cur == null) return;
        max = Math.max(max, level);
        dfs(cur.left, level + 1);
        dfs(cur.right, level + 1);
    }
}