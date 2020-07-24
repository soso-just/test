package coding.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ValidBST {
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
        LinkedList<Integer> tranversalList = new LinkedList<Integer>();
        return inorderTraversalIsAes(root,tranversalList);
    }

    /**
     * 前序遍历并升序
     * @param root
     * @param tranversalList
     * @return
     * @费解点： 原来只想记录上次被遍历到的节点值，但是Integer在递归中赋值后带不出来！！！！ {@link ValidBST_ERROR}
     */
    private static boolean inorderTraversalIsAes(TreeNode root, LinkedList<Integer> tranversalList) {
        if (root.left != null) {
            boolean leftResult = inorderTraversalIsAes(root.left, tranversalList);
            if (!leftResult) {
                return false;
            }
        }
        int currentValue = root.val;

        if (!tranversalList.isEmpty() && tranversalList.getLast() >= currentValue) {
            return false;
        }
        tranversalList.addLast(currentValue);
        if (root.right != null) {
            boolean rightResult = inorderTraversalIsAes(root.right, tranversalList);
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
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(3);
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
