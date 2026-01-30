package disjointset;

public class NumberOfProvinces_547 {
  int[] roots;
  int numSets;
  int TOTAL_NODES;

  // compress path
  // point directly to the root
  private int find(int a) {
    if(roots[a] == -1) {
      return a;
    }
    int root = find(roots[a]);
    roots[a] = root;
    return root;
  }

  private void union(int a, int b) {
    int ra = find(a), rb = find(b);
    if(ra == rb) {
      return;
    }
    roots[rb] = ra;
    numSets--;
  }

  private void initialize(int[][] isConnected) {
    int R = isConnected.length;
    roots = new int[R];
    numSets = R;
    TOTAL_NODES = R;

    for(int i = 0; i < R; i++) {
        roots[i] = -1;
    }
  }

  public int findCircleNum(int[][] isConnected) {
    initialize(isConnected);
    formDisjointSetForest(isConnected);
    return numSets;
  }

  private void formDisjointSetForest(int[][] isConnected) {
    for(int r = 0; r < TOTAL_NODES; r++) {
      for(int c = 0; c < TOTAL_NODES; c++) {
        if(r == c) {
          continue;
        }
        if(isConnected[r][c] == 1) {
          union(r, c);
        }
      }
    }
  }
}

class NumberOfProvinces_0_547 {
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
