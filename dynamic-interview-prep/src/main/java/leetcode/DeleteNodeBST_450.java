package leetcode;



public class DeleteNodeBST_450 {

  public TreeNode deleteNode(TreeNode curNode, int key) {
    if(curNode == null) {
      return null;
    }

    int curVal = curNode.val;
    if(curVal > key) {
      curNode.left = deleteNode(curNode.left, key);
      return curNode;
    } else if(curVal < key) {
      curNode.right = deleteNode(curNode.right, key);
      return curNode;
    }

    // this is the target node :)
    TreeNode left = curNode.left, right = curNode.right;
    if(left != null && right != null) {
      return deleteTargetNodeWithTwoChild(curNode);
    } else if (left != null && right == null) {
      curNode.left = null;
      return left;
    } else if (left == null && right != null) {
      curNode.right = null;
      return right;
    } else {
      return null;
    }
  }

  private TreeNode deleteTargetNodeWithTwoChild(TreeNode targetNode) {
    TreeNode left = targetNode.left, right = targetNode.right, newRoot;

    // find new root
    if(right.left == null) {
      // new root will be the left most node on the right side of the targetNode
      //                  8
      //                 / \
      //                6   10
      //                      \
      //                      20
      // target node is 8. 10 will be the new root
      //                 10
      //                /  \
      //               6   20

      newRoot = right;
    } else {
      // new root will be the left most node on the right side of the targetNode
      //                  8
      //                 / \
      //                6   14
      //                   /  \
      //                  9    20
      //                   \
      //                    10
      //                      \
      //                      12
      // target node is 8. 9 will be the new root
      //                  9
      //                 / \
      //                6   14
      //                   /  \
      //                  10   20
      //                    \
      //                     12

      TreeNode parentOfNewRoot = right;
      newRoot = right.left;
      while(newRoot.left != null) {
        parentOfNewRoot = parentOfNewRoot.left;
        newRoot = parentOfNewRoot.left;
      }
      parentOfNewRoot.left = newRoot.right;
      newRoot.right = targetNode.right;
    }

    newRoot.left = targetNode.left;
    targetNode.left = null;
    targetNode.right = null;
    return newRoot;
  }
}
