package trees_and_graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTrees_95 {
  public List<TreeNode> generateTrees(int n) {
    return helper(1, n);
  }

  private List<TreeNode> helper(int l, int h) {
    if(l > h) {
      List<TreeNode> res = new LinkedList<>();
      res.add(null);
      return res;
    } else if(l == h) {
      return Arrays.asList(new TreeNode(l));
    } else {
      List<TreeNode> res = new LinkedList<>();
      for (int root = l; root <= h; root++) {
        List<TreeNode> leftSubTrees = helper(l, root-1);
        List<TreeNode> rightSubTrees = helper(root+1, h);
        for (TreeNode left : leftSubTrees) {
          for (TreeNode right : rightSubTrees) {
            TreeNode rt = new TreeNode(root);
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
