package disjointset;



public class GraphValidTree_261 {
  public boolean validTree(int n, int[][] edges) {
    DisjoinSet disjoinSet = new DisjoinSet(n);
    for (int[] edge : edges){
        int src = edge[0];
        int dest = edge[1];
        if (src > dest) {
          int t = src;
          src = dest;
          dest = t;
        }
        if (disjoinSet.connected(src, dest)) {
          return false;
        }
        disjoinSet.union(src, dest);

    }
    return disjoinSet.getNumCompoonents() == 1;
  }
}

