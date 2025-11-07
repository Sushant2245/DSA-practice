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
    public int maxLevelSum(TreeNode root) {
        if(root==null)return 0;
        Map<Integer,Integer> map= new HashMap<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        int max=Integer.MIN_VALUE;
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
            
                TreeNode current=q.poll();
                sum+=current.val;
                 if(current.left!=null)q.add(current.left);
                 if(current.right!=null)q.add(current.right);
            }
            max=Math.max(max,sum);
          if(!map.containsKey(sum)){
            map.put(sum,level);
          }
          level++;
         
          

        }
        return map.get(max);
    }
}