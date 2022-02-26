package trees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths_257 {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new LinkedList<>();
    if (root == null) {
      return paths;
    }
    helper(root, "", paths);
    return paths;
  }

  private void helper(TreeNode root, String curPath, List<String> paths) {
    curPath = curPath + root.val;
    if (root.left == null && root.right == null) {
      paths.add(curPath);
      return;
    }
    curPath = curPath + "->";
    if (root.left != null) {
      helper(root.left, curPath, paths);
    }

    if (root.right != null) {
      helper(root.right, curPath, paths);
    }
  }
}
