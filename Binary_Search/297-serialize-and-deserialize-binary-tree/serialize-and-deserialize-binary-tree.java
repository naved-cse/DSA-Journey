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
        StringBuilder clipboard = new StringBuilder();
        buildString(root, clipboard);
        return clipboard.toString();
    }
    private void buildString(TreeNode node, StringBuilder clipboard){
        if(node == null){
            clipboard.append("X,");
            return;
        }

        clipboard.append(node.val).append(",");
        buildString(node.left, clipboard);
        buildString(node.right, clipboard);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return unpack(queue);
    }

    private TreeNode unpack(Queue<String> queue){
        String val = queue.poll();

        if (val.equals("X")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = unpack(queue);
        node.right = unpack(queue);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));