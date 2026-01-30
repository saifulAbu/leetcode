package disjointset;

public class FindIfPathExists_1971 {
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    DisjoinSet disjoinSet = new DisjoinSet(n);
    for (int[] edge : edges) {
      disjoinSet.union(edge[0], edge[1]);
    }

    return disjoinSet.find(source) == disjoinSet.find(destination);
  }
}
