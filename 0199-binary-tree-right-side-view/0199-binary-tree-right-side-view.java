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
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return result;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> sublist= new ArrayList<>();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                sublist.add(q.poll().val);
            }
            result.add(sublist.get(sublist.size()-1));
        }
        return result;
    }
}