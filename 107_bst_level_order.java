package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class BinaryTreeLevelOrderTraversalII {
  static class TreeNode {
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

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList result = new LinkedList<LinkedList<Integer>>();
    if(root == null) {
      return result;
    }
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    traverse(root, map, 0);
    int maxHeight = map.size();
    for(int i = maxHeight - 1; i >= 0; i--) {
      result.add(map.get(i));
    }
    return result;
  }

  private void traverse(TreeNode root, Map<Integer, List<Integer>> map, int level) {
    map.putIfAbsent(level, new LinkedList<Integer>());
    List list = map.get(level);
    list.add(root.val);
    if(root.left != null) {
      traverse(root.left, map, level+1);
    }
    if(root.right != null) {
      traverse(root.right, map, level+1);
    }
  }

  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversalII bst = new BinaryTreeLevelOrderTraversalII();
    TreeNode n3 = new TreeNode(3);
    TreeNode n9 = new TreeNode(9);
    TreeNode n20 = new TreeNode(20);
    TreeNode n15 = new TreeNode(15);
    TreeNode n7 = new TreeNode(7);

    n3.left = n9;
    n3.right = n20;
    n20.left = n15;
    n20.right = n7;

    List<List<Integer>> result = bst.levelOrderBottom(n7);
    System.out.println(result);
  }
}
