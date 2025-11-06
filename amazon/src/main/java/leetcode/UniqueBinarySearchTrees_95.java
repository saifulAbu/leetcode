package leetcode;

import z_trash.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTrees_95 {
  public List<z_trash.TreeNode> generateTrees(int n) {
    return helper(1, n);
  }

  private List<z_trash.TreeNode> helper(int l, int h) {
    if(l > h) {
      List<z_trash.TreeNode> res = new LinkedList<>();
      res.add(null);
      return res;
    } else if(l == h) {
      return Arrays.asList(new z_trash.TreeNode(l));
    } else {
      List<z_trash.TreeNode> res = new LinkedList<>();
      for (int root = l; root <= h; root++) {
        List<z_trash.TreeNode> leftSubTrees = helper(l, root-1);
        List<z_trash.TreeNode> rightSubTrees = helper(root+1, h);
        for (z_trash.TreeNode left : leftSubTrees) {
          for (z_trash.TreeNode right : rightSubTrees) {
            z_trash.TreeNode rt = new TreeNode(root);
            rt.left = left;
            rt.right = right;
            res.add(rt);
          }
        }
      }
      return res;
    }
  }
}
