package com.company;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class KThSmallest {
    private int currentSmallest = 0;

    public int kthSmallest(TreeNode root, int k) {
        return traverseInOrder(root, k);
    }

    private int traverseInOrder(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        int leftResult = traverseInOrder(root.left, k);
        if(leftResult != 0) {
            return leftResult;
        }
        currentSmallest++;
        if(currentSmallest == k){
            return root.val;
        }
        int rightResult = traverseInOrder(root.right, k);
        return rightResult;
    }

    public static void main(String args[]) {
        KThSmallest kth = new KThSmallest();

        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t9 = new TreeNode(9);
        t5.left = t1;
        t5.right = t9;

        int v = kth.kthSmallest(t1, 1);
        System.out.println(v);
    }
}
