package alpha_rep;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {

  public List<List<Integer>> levelOrder_2(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    if(root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      int curSize = queue.size();
      List<Integer> curLevel = new LinkedList<>();
      for(int i = 0; i < curSize; i++) {
        TreeNode curNode = queue.poll();
        curLevel.add(curNode.val);
        if(curNode.left != null) {
          queue.offer(curNode.left);
        }
        if(curNode.right != null) {
          queue.offer(curNode.right);
        }
      }
      result.add(curLevel);
    }
    return result;
  }

  public List<List<Integer>> levelOrder_1(TreeNode root) {
    List<List<Integer>> levelOrder = new LinkedList<>();
    if(root == null) {
      return levelOrder;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
      int curQSize = q.size();
      LinkedList<Integer> curLevel = new LinkedList<>();
      for(int i = 0; i < curQSize; i++) {
        TreeNode curNode = q.poll();
        curLevel.add(curNode.val);
        if(curNode.left != null) {
          q.offer(curNode.left);
        }
        if(curNode.right != null) {
          q.offer(curNode.right);
        }
      }
      levelOrder.add(curLevel);
    }
    return levelOrder;
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    /*
    * level order traversal is asked so we will use BFS here
    * */

    List<List<Integer>> resultList = new LinkedList<>();

    if(root == null) {
      return resultList;
    }

    Deque<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()) {
      int curQSize = q.size();

      List<Integer> curList = new LinkedList<>();
      for(int i = 0; i < curQSize; i++) {
        TreeNode curNode = q.poll();
        if(curNode.left != null) {
          q.offer(curNode.left);
        }
        if(curNode.right != null) {
          q.offer(curNode.right);
        }
        curList.add(curNode.val);
      }
      resultList.add(curList);
    }

    return resultList;
  }

  public List<List<Integer>> levelOrder_02(TreeNode root) {
    List<List<Integer>> levels = new LinkedList<>();
    if(root == null) {
      return levels;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
      //how many nodes are in current level
      int curLevelSize = q.size();
      List<Integer> curLevel = new LinkedList<>();

      // extract all the nodes from curLevel
      for(int i = 0; i < curLevelSize; i++) {
        TreeNode curNode = q.poll();
        curLevel.add(curNode.val);
        //traverse through neighbors and put them in queue
        if(curNode.left != null) {
          q.offer(curNode.left);
        }

        if(curNode.right != null) {
          q.offer(curNode.right);
        }
      }
      levels.add(curLevel);
    }
    return levels;
  }

  public List<List<Integer>> levelOrder_01(TreeNode root) {
    List<List<Integer>> levels = new LinkedList<>();
    Queue<TreeNode> q = new LinkedList<>();

    if(root != null) {
      q.offer(root);
    }

    // apply BFS to get values on a level
    while(!q.isEmpty()) {
      List<Integer> curLevelValues = new LinkedList<>();
      int curLevelSize = q.size();

      for(int i = 0; i < curLevelSize; i++) {
        TreeNode node = q.poll();
        curLevelValues.add(node.val);
        if(node.left != null) {
          q.offer(node.left);
        }
        if(node.right != null) {
          q.offer(node.right);
        }
      }
      levels.add(curLevelValues);
    }

    return levels;
  }

  public List<List<Integer>> levelOrder_00(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    HashMap<Integer, List<Integer>> levelOrderMap = new HashMap<>();
    traverseHelper0(root, 0, levelOrderMap);
    result = new ArrayList<>(levelOrderMap.values());
    return result;
  }

  private void traverseHelper0(TreeNode root, int level, HashMap<Integer, List<Integer>> levelOrderMap) {
    levelOrderMap.putIfAbsent(level, new ArrayList<Integer>());
    levelOrderMap.get(level).add(root.val);
    if (root.left != null) {
      traverseHelper0(root.left, level + 1, levelOrderMap);
    }

    if (root.right != null) {
      traverseHelper0(root.right, level + 1, levelOrderMap);
    }
  }
}
