package disjointset;

public class NumberOfProvinces_547 {
  int [] parent;
  int numSets;
  public int findCircleNum(int[][] isConnected) {
    parent = new int[isConnected.length];
    numSets = parent.length;

    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    for (int r = 0; r < parent.length - 1; r++) {
      for (int c = r + 1; c < parent.length; c++ ) {
        if (isConnected[r][c] == 1) {
          union(r, c);
        }
      }
    }

    return numSets;
  }

  void union(int n0, int n1) {
    int p0 = getParent(n0);
    int p1 = getParent(n1);

    if (p0 == p1)
      return ;

    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == p1) {
        parent[i] = p0;
      }
    }
    numSets--;
  }

  private int getParent(int n) {
    return parent[n];
  }

}
