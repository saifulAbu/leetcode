package trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeZigZag_103 {
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

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    HashMap<Integer, ArrayList<Integer>> resMap = new HashMap<>();
    helperZigzag(root, 0, resMap);
    return new ArrayList<>(resMap.values());
  }

  private void helperZigzag(TreeNode root, int level, HashMap<Integer, ArrayList<Integer>> resMap) {
    resMap.putIfAbsent(level, new ArrayList<Integer>());
    ArrayList<Integer> curList = resMap.get(level);
    if(level % 2 == 0) {
      curList.add(root.val);
    } else {
      curList.add(0, root.val);
    }
    if(root.left != null) {
      helperZigzag(root.left, level + 1, resMap);
    }
    if(root.right != null) {
      helperZigzag(root.right, level + 1, resMap);
    }
  }

  public static void main(String args[]) {

    TreeNode n0 = new TreeNode(1);

    TreeNode n1 = new TreeNode(2);
    TreeNode n2 = new TreeNode(3);

    TreeNode n3 = new TreeNode(4);
    TreeNode n4 = new TreeNode(5);
    TreeNode n5 = new TreeNode(6);
    TreeNode n6 = new TreeNode(7);

    n0.left = n1;
    n0.right = n2;

    n1.left = n3;
    n1.right = n4;
    n2.left = n5;
    n2.right = n6;

    BinaryTreeZigZag_103 btz = new BinaryTreeZigZag_103();
    List<List<Integer>> result = btz.zigzagLevelOrder(n0);
    return;
  }

}