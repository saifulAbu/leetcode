package alpha_rep;

public class ReduntantConnection_684 {
  int[] root;
  int n;
  public int[] findRedundantConnection(int[][] edges) {
    n = edges.length;
    root = new int[n+1];
    for(int i = 0; i < n; i++) {
      root[i] = -1;
    }

    int[] result = null;
    for(int[] edge : edges) {
      int n0 = edge[0], n1 = edge[1];
      if(find(n0) == find(n1)) {
        result = edge;
        break;
      } else {
        union(n0, n1);
      }
    }
    return result;
  }

  int find(int node) {
    if(root[node] == -1) {
      return node;
    } else {
      root[node] = find(root[node]);
      return root[node];
    }
  }

  void union(int n0, int n1) {
    int r0 = find(n0);
    int r1 = find(n1);
    root[r1] = r0;
  }

  public int[] findRedundantConnection_drona(int[][] edges) {
    int n = edges.length;
    int[] parent = new int[n + 1];

    // Initialize each node as its own parent
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      // If u and v already share the same root, this edge forms a cycle
      if (find(parent, u) == find(parent, v)) {
        return edge;
      }

      // Otherwise union them
      union(parent, u, v);
    }

    return new int[0];
  }

  private int find(int[] parent, int x) {
    if (parent[x] != x) {
      parent[x] = find(parent, parent[x]); // path compression
    }
    return parent[x];
  }

  private void union(int[] parent, int a, int b) {
    int rootA = find(parent, a);
    int rootB = find(parent, b);
    parent[rootB] = rootA; // simple union
  }

}
