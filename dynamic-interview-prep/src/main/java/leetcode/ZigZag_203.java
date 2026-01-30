package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ZigZag_203 {
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() { }
    TreeNode(int val) {
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  };

  HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return mapToList(map);
    }
    helper(0, root);
    return mapToList(map);
  }

  private void helper(int level, TreeNode root) {
    LinkedList<Integer> cur = map.get(level);
    if (cur == null) {
      cur = new LinkedList<>();
      map.put(level, cur);
    }
    if (level % 2 == 0) {
      cur.addLast(root.val);
    } else {
      cur.addFirst(root.val);
    }

    if (root.left != null) {
      helper(level + 1, root.left);
    }
    if (root.right != null) {
      helper(level + 1, root.right);
    }
  }

  private List<List<Integer>> mapToList(HashMap<Integer, LinkedList<Integer>> map) {
    List<List<Integer>> list = new LinkedList<>();
    for (int i = 0; i < map.size(); i++) {
      list.add(map.get(i));
    }
    return list;
  }
}
