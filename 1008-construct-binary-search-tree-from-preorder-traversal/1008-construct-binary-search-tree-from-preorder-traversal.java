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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        if(n==0)return null;
        TreeNode root= new TreeNode(preorder[0]);
        for(int i=1;i<n;i++){
            helper(preorder[i],root);
        }
        return root;
    }
    public void helper(int val,TreeNode root){
        while(true){
            if(root.val>val){
                if(root.left==null){
                   root.left= new TreeNode(val);
                   return;
                }
                root=root.left;
            }
            else{
                if(root.right==null){
                    root.right=new TreeNode(val);
                    return;
                }
                root=root.right;

            }
        }
    }
}