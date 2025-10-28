/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void func(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode>q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current= q.poll();
            if(current.left!=null){
                q.offer(current.left);
                parent.put(current.left,current);
            }
            if(current.right!=null){
                q.offer(current.right);
                parent.put(current.right,current);
            }
           
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent= new HashMap<>();
        func(root,parent);
        Queue<TreeNode> q= new LinkedList<>();
        Map<TreeNode,Boolean> visited=new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int distance=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(distance==k)break;
            distance++;
            for(int i=0;i<size;i++){
                TreeNode current= q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parent.get(current)!=null && visited.get(parent.get(current))==null){
                    q.offer(parent.get(current));
                    visited.put(parent.get(current),true);
                }
            }
        }
        List<Integer> result= new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;

    }
    
}