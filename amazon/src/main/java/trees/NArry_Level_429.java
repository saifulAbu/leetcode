package trees;

import java.util.*;

public class NArry_Level_429 {
  private static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null) {
      return res;
    }
    Queue<Node> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      ArrayList<Integer> curNodes = new ArrayList<>(size);
      for (int i = 0;i < size; i++) {
        Node cur = q.poll();
        for (Node child : cur.children) {
          q.offer(child);
        }
        curNodes.add(cur.val);
      }
      res.add(curNodes);
    }
    return res;
  }

}
