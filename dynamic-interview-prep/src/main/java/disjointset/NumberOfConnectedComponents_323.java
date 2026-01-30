package disjointset;

public class NumberOfConnectedComponents_323 {
  public int countComponents(int n, int[][] edges) {
    DisjoinSet disjoinSet = new DisjoinSet(n);
    for (int[] edge : edges) {
      int src = edge[0];
      int dest = edge[1];
      disjoinSet.union(src, dest);
    }
    return disjoinSet.getNumCompoonents();
  }
}
