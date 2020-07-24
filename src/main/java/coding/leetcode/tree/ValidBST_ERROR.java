package coding.leetcode.tree;

import java.util.LinkedList;

public class ValidBST_ERROR {
    /**
     *  Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * check is a valid binary sort tree
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer lastTranversalValue = null;
        return inorderTraversalIsAes(root,lastTranversalValue);
    }

    /**
     * 中序遍历并升序
     * @param root
     * @param lastTranversalValue
     * @return
     */
    private static boolean inorderTraversalIsAes(TreeNode root, Integer lastTranversalValue) {
        if (root.left != null) {
            //递归内部对lastTranversalValue赋值后，无法“带回来”
            boolean leftResult = inorderTraversalIsAes(root.left, lastTranversalValue);
            if (!leftResult) {
                return false;
            }
        }
        int currentValue = root.val;
        if (lastTranversalValue!=null && lastTranversalValue >= currentValue) {
            return false;
        }
        lastTranversalValue = currentValue;
        if (root.right != null) {
            boolean rightResult = inorderTraversalIsAes(root.right, lastTranversalValue);
            if (!rightResult) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode node1 = new TreeNode(1);
//        root.left = node1;
//        TreeNode node4 = new TreeNode(7);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(6);
//        node4.left = node3;
//        node4.right = node6;
//        root.right = node4;

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        root.left=node1;


        System.out.println(isValidBST(root));
    }

}
