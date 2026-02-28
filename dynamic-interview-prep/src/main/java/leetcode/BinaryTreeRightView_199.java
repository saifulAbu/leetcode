package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightView_199 {
  public List<Integer> rightSideView(TreeNode root) {
    /*
    * do bfs, maintain the values in a queue
    * from each level, take the value of the last element
    * */

    LinkedList<Integer> rightView = new LinkedList<>();
    if(root == null) return rightView;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
      int curQSize = q.size();
      for(int i  = 0; i < curQSize; i++) {
        TreeNode curNode = q.poll();
        if(i == curQSize - 1) {
          rightView.addLast(curNode.val);
        }
        if(curNode.left != null) {
          q.offer(curNode.left);
        }
        if(curNode.right != null) {
          q.offer(curNode.right);
        }
      }
    }

    return rightView;
  }
}
