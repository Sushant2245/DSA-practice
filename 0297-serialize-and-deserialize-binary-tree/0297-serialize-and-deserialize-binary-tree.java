/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q= new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode n=q.poll();
            if(n==null){
                sb.append("null,");
                continue;
            }
            sb.append(n.val).append(",");
            q.offer(n.left);
            q.offer(n.right);
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals("")) return null;
        Queue<TreeNode> q= new LinkedList<>();
        String[]arr=data.split(",");
        TreeNode root= new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
       for(int i=1;i<arr.length;i++){
          TreeNode parent= q.poll();
          if(!arr[i].equals("null")){
            TreeNode left= new TreeNode(Integer.parseInt(arr[i]));
            parent.left=left;
            q.add(left);
          }
          i++;
          if(i<arr.length && !arr[i].equals("null")){
            TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
            parent.right=right;
            q.offer(right);
          }
       }
       return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();// TreeNode ans = deser.deserialize(ser.serialize(root));