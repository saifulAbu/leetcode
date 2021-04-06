package trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class FindLonelyNodes_1469 {
  List<Integer> lonely = new ArrayList<>();
  public List<Integer> getLonelyNodes(TreeNode root) {
    getLonely(root);
    return lonely;
  }

  private void getLonely(TreeNode root) {
    if(root == null) {
      return;
    }
    int numChild = 0;
    if(root.left != null) {
      numChild++;
      getLonely(root.left);
    }
    if(root.right != null) {
      numChild++;
      getLonely(root.right);
    }
    if(numChild == 1) {
      if(root.left != null) {
        lonely.add(root.left.val);
      } else {
        lonely.add(root.right.val);
      }
    }
  }
}
