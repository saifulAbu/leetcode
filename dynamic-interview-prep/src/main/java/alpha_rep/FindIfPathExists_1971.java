package alpha_rep;

public class FindIfPathExists_1971 {
  /*
  * we solve the problem using DisjointSet forest, 3 operations (union, findParent, isConnected)
  * operations are O(n)
  *
  * */
  class DisjoinSet {
    int [] s;
    DisjoinSet(int n) {
      s = new int[n];
      for(int i = 0; i < n; i++) {
        s[i] = -1;
      }
    }

    void union(int a, int b) {
      int ra = findParent(a), rb = findParent(b);
      if(ra == rb) {
        return;
      }
      s[rb] = ra;
    }

    boolean connected(int a, int b) {
      return findParent(a) == findParent(b);
    }

    private int findParent(int a) {
      if(s[a] == -1) {
        return a;
      }
      return s[a] = findParent(s[a]);
    }
  }

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    DisjoinSet disjoinSet = new DisjoinSet(n);
    for(int[] edge : edges) {
      disjoinSet.union(edge[0], edge[1]);
    }
    return disjoinSet.connected(source, destination);
  }
}
