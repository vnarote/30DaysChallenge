class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { 
        this.val = val; 
        left = null; 
        right = null; 
    }
}

public class Challenge27 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right); 
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true; 
        if (left == null || right == null) return false; 
        if (left.val != right.val) return false; 
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    public TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0) return null;
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                nodes[i] = new TreeNode(arr[i]);
            } else {
                nodes[i] = null;
            }
        }
        for (int i = 0, j = 1; j < arr.length;) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[j++];
                if (j < arr.length) nodes[i].right = nodes[j++];
            } else {
                i++;
            }
            i++;
        }
        return nodes.length > 0 ? nodes[0] : null; 
    }

    public static void main(String[] args) {
        Challenge27 st = new Challenge27();
        // Test case 1
        Integer[] t1 = {1,2,2,3,4,4,3};
        TreeNode root1 = st.buildTree(t1);
        System.out.println("Test 1: " + st.isSymmetric(root1)); 

        // Test case 2
        Integer[] t2 = {1,2,2,null,3,null,3};
        TreeNode root2 = st.buildTree(t2);
        System.out.println("Test 2: " + st.isSymmetric(root2)); 

        // Test case 3
        Integer[] t3 = {1};
        TreeNode root3 = st.buildTree(t3);
        System.out.println("Test 3: " + st.isSymmetric(root3)); 

        // Test case 4 (Empty tree)
        Integer[] t4 = {};
        TreeNode root4 = st.buildTree(t4);
        System.out.println("Test 4: " + st.isSymmetric(root4)); 

        // Test case 5
        Integer[] t5 = {1,2,2,3,null,null,3};
        TreeNode root5 = st.buildTree(t5);
        System.out.println("Test 5: " + st.isSymmetric(root5)); 

       
    }
}
