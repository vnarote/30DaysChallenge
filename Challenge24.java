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

public class Challenge24 {

    public boolean isBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Challenge24 checker = new Challenge24();

        // Test case 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test 1: " + checker.isBST(root1)); 

        // Test case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test 2: " + checker.isBST(root2)); 

        // Test case 3
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println("Test 3: " + checker.isBST(root3)); 

        // Edge Case 1 : Only one node
        TreeNode root4 = new TreeNode(1);
        System.out.println("Test 4: " + checker.isBST(root4)); 

        // Edge Case 2 : Tree with repeated values
        TreeNode root5 = new TreeNode(2);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        System.out.println("Test 5: " + checker.isBST(root5)); 

        // Edge Case 3: Subtree violates property at deeper level
        TreeNode root6 = new TreeNode(20);
        root6.left = new TreeNode(10);
        root6.right = new TreeNode(30);
        root6.left.right = new TreeNode(25);
        System.out.println("Test 6: " + checker.isBST(root6)); 
    }
}
