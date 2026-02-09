package alpha_rep;

public class IsSameTree_100 {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    /*
    * we will check recursively
    * we will go all the way to the leaf of a tree and check if they are equal or not
    * and move up from there
    *
    * */
    if(p == null && q == null) {
      return true;
    }

    // one of them is null
    if(p == null || q == null) {
      return false;
    }

    if(p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public boolean isSameTree_0(TreeNode p, TreeNode q) {
    if(p == null && q == null) {
      return true;
    }
    if(p == null || q == null ) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
