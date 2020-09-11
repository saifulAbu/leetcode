package com.company;

public class FormBSTFromPreorderTrav {


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

    private int curIndex = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return formTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode formTree(int[] preorder, int min, int max){
        int curVal = preorder[curIndex];
        if(curVal < min || curVal > max) {
            return null;
        }
        TreeNode node = new TreeNode(curVal);
        curIndex++;
        if(curIndex < preorder.length) {
            node.left = formTree(preorder, min,curVal - 1);
        }
        if(curIndex < preorder.length) {
            node.right = formTree(preorder, curVal + 1, max);
        }
        return node;
    }

    public static void main(String args[]) {
        FormBSTFromPreorderTrav solution = new FormBSTFromPreorderTrav();
        //int arr [] = {8,5,1,7,10,12};
        int arr [] = {8, 5, 1, 7, 10};
        TreeNode root = solution.bstFromPreorder(arr);
        return;
    }
}
