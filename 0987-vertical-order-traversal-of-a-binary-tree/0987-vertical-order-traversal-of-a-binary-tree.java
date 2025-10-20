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
    static class Node{
        TreeNode node;
        int v;
        int l;
        Node(TreeNode n,int vertical,int level){
            node=n;
            v=vertical;
            l=level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Node> q= new LinkedList<>();
        q.offer(new Node(root,0,0));
        while(!q.isEmpty()){
            Node temp= q.poll();
            TreeNode n=temp.node;
            int v=temp.v;
            int l=temp.l;
            map.putIfAbsent(v,new TreeMap<>());
            map.get(v).putIfAbsent(l,new PriorityQueue<>());
            map.get(v).get(l).offer(n.val);

            if(n.left!=null)q.offer(new Node(n.left,v-1,l+1));
            if(n.right!=null)q.offer(new Node(n.right,v+1,l+1));
            
        }
        List<List<Integer>> result = new ArrayList<>();
        
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) colList.add(pq.poll());
            }
            result.add(colList);
        }
        return result;
    }
}