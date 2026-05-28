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
    int idx =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder,inorder,0,n-1);
    }
    public TreeNode helper(int[] preorder, int [] inorder, int start , int end){
        if(start > end){
            return null;
        }

        int val = preorder[idx++];

        int i = start;

        for(;i<=end;i++){
            if(inorder[i] == val) break;
        }

        TreeNode root = new TreeNode(val);

        root.left = helper(preorder, inorder ,start ,i-1);
        root.right = helper(preorder , inorder , i+1 , end);

        return root;
    }
}