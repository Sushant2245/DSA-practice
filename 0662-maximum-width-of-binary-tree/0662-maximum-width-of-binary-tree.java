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
    public int widthOfBinaryTree(TreeNode root) {
       if(root==null) return 0;
       Queue<Pair<TreeNode,Integer>> q= new LinkedList<>(); 
       int max=0;
       q.offer(new Pair<>(root,0));
       while(!q.isEmpty()){
        int size=q.size();
        int minIndex=q.peek().getValue();
        int first=0;
        int last=0;
        for(int i=0;i<size;i++){
            Pair<TreeNode,Integer> p=q.poll();
            TreeNode n=p.getKey();
            int index=p.getValue()-minIndex;
            
            if(i==0)first=index;
            if(i==size-1)last=index;

            if(n.left!=null) q.offer(new Pair<>(n.left,2*index));
            if(n.right!=null) q.offer(new Pair<>(n.right,2*index+1));
        }
        max=Math.max(max,(last-first+1));
       }
       return max;
    }
}