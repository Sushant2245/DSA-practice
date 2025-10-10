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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        Stack<List<Integer>> st= new Stack<>();
        if(root==null) return result;
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                sublist.add(q.poll().val);
               
            }
             st.push(sublist);
        }
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
    }
}