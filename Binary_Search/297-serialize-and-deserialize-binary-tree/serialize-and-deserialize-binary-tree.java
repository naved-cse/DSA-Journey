public class Codec {

    // ==========================================
    // THE PACKER (Serialize)
    // Converts the Tree into a String blueprint
    // ==========================================
    public String serialize(TreeNode root) {
        StringBuilder clipboard = new StringBuilder();
        buildString(root, clipboard); // Start the recursive boomerang
        return clipboard.toString();  // Hand the final string to LeetCode
    }

    private void buildString(TreeNode node, StringBuilder clipboard) {
        // 1. BASE CASE: Record the dead end ("X") so we keep the exact shape!
        if (node == null) {
            clipboard.append("X,"); 
            return;
        }

        // 2. RECORD CURRENT NODE: Write the number and add a comma barrier
        // We use method chaining here to save space
        clipboard.append(node.val).append(",");

        // 3. THE THROW: Dive down the left side, then the right side
        buildString(node.left, clipboard);
        buildString(node.right, clipboard);
    }

    // ==========================================
    // THE UNPACKER (Deserialize)
    // Reads the String blueprint and builds a NEW Tree
    // ==========================================
    public TreeNode deserialize(String data) {
        // Chop the string at every comma, and dump all pieces into a line (Queue)
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return unpack(queue); // Start building!
    }

    private TreeNode unpack(Queue<String> queue) {
        // 1. Grab and delete the next piece of data from the front of the line
        String val = queue.poll();
        
        // 2. BASE CASE: If we read an "X", it's a dead end. Return null!
        if (val.equals("X")) {
            return null;
        }
        
        // 3. CREATE THE NODE: Convert the text back into a real TreeNode
        TreeNode node = new TreeNode(Integer.parseInt(val));
        
        // 4. THE MAGIC RECURSION: 
        // Because we packed it Node -> Left -> Right, we unpack it the exact same way.
        // The left side will completely finish eating its numbers from the queue 
        // before the right side even starts!
        node.left = unpack(queue);
        node.right = unpack(queue);
        
        // 5. RETURN UPWARD: Hand this finished subtree back up to whoever called it
        return node;
    }
}