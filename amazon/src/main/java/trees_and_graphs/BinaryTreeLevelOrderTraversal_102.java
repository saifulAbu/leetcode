package trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
  public static class TreeNode {
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

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    HashMap<Integer, List<Integer>> levelOrderMap = new HashMap<>();
    traverseHelper(root, 0, levelOrderMap);
    result = new ArrayList<>(levelOrderMap.values());
    return result;
  }

  private void traverseHelper(TreeNode root, int level, HashMap<Integer, List<Integer>> levelOrderMap) {
    levelOrderMap.putIfAbsent(level, new ArrayList<Integer>());
    levelOrderMap.get(level).add(root.val);
    if(root.left != null) {
      traverseHelper(root.left, level+1, levelOrderMap);
    }

    if(root.right != null) {
      traverseHelper(root.right, level+1, levelOrderMap);
    }
  }
}
