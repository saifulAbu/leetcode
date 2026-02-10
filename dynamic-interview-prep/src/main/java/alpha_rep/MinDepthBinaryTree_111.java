package alpha_rep;

import java.util.Deque;
import java.util.LinkedList;

public class MinDepthBinaryTree_111 {
  public int minDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }

    Deque<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int minDepth = 0;

    while(!q.isEmpty()) {
      int curSize = q.size();
      minDepth++;
      for(int i = 0; i < curSize; i++) {
       TreeNode curNode = q.poll();
       if(curNode.left == null && curNode.right == null) {
         return minDepth;
       }
       if(curNode.left != null) {
         q.offer(curNode.left);
       }

       if(curNode.right != null) {
         q.offer(curNode.right);
       }
      }
    }

    return minDepth;

  }

  public int minDepth_01(TreeNode root) {
      if(root == null) {
        return 0;
      }
    return getNumNode(root);
  }

  private int getNumNode(TreeNode root) {

    if(root.left == null && root.right == null) {
      return 1;
    }
    int left = Integer.MAX_VALUE;
    if(root.left != null) {
      left = getNumNode(root.left);
    }

    int right = Integer.MAX_VALUE;
    if(root.right != null) {
      right = getNumNode(root.right);
    }

    return Math.min(left, right) + 1;
  }
}
