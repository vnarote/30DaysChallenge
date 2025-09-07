class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Challenge23 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                nodes[i] = new TreeNode(arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] != null) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                if (left < arr.length) nodes[i].left = nodes[left];
                if (right < arr.length) nodes[i].right = nodes[right];
            }
        }
        return nodes[0];
    }

    public TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        Challenge23 sol = new Challenge23();
        // Test case 1
        Integer[] arr1 = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root1 = sol.buildTree(arr1);
        TreeNode p1 = sol.findNode(root1, 5);
        TreeNode q1 = sol.findNode(root1, 1);
        System.out.println("Output: " + sol.lowestCommonAncestor(root1, p1, q1).val);
        // Test case 2
        TreeNode p2 = sol.findNode(root1, 5);
        TreeNode q2 = sol.findNode(root1, 4);
        System.out.println(" Output: " + sol.lowestCommonAncestor(root1, p2, q2).val); 
        // Test case 3
        Integer[] arr2 = {1, 2};
        TreeNode root2 = sol.buildTree(arr2);
        TreeNode p3 = sol.findNode(root2, 1);
        TreeNode q3 = sol.findNode(root2, 2);
        System.out.println(" Output: " + sol.lowestCommonAncestor(root2, p3, q3).val); 
        // Edge case 1: both nodes are the same
        TreeNode p4 = sol.findNode(root1, 5);
        TreeNode q4 = sol.findNode(root1, 5);
        System.out.println("Edge Case - Same Node Output: " + sol.lowestCommonAncestor(root1, p4, q4).val); 
        // Edge case 2: one node is the root
        TreeNode p5 = sol.findNode(root1, 3);
        TreeNode q5 = sol.findNode(root1, 5);
        System.out.println("Edge Case - Root Output: " + sol.lowestCommonAncestor(root1, p5, q5).val); 
        // Edge case 3: Small tree (only two nodes)
        TreeNode p6 = sol.findNode(root2, 2);
        TreeNode q6 = sol.findNode(root2, 2);
        System.out.println("Edge Case - Small Tree Output: " + sol.lowestCommonAncestor(root2, p6, q6).val); 
    }
}
