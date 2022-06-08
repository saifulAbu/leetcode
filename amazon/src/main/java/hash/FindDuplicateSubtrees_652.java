package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateSubtrees_652 {
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

  HashMap<String, List<TreeNode>> map = new HashMap<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    populateHashMap(root);
    return filterList();
  }

  List<TreeNode> filterList() {
    List<TreeNode> res = new LinkedList<>();
    for(String key : map.keySet()) {
      if(map.get(key).size() > 1) {
        res.add(map.get(key).get(0));
      }
    }
    return res;
  }

  String populateHashMap(TreeNode root) {
    String hash = "";
    if (root.left == null && root.right == null) {
      hash = hash + root.val;
    } else {
      if (root.left != null) {
        hash = populateHashMap(root.left);
      }

      hash = hash + root.val;

      if (root.right != null) {
        hash = hash + populateHashMap(root.right);
      }
    }

    hash = "(" + hash + ")";
    map.putIfAbsent(hash, new LinkedList<>());
    map.get(hash).add(root);
    return hash;
  }
}
