package disjointset;

class DisjoinSet {
  int [] rank, parent;
  int size;
  int numCompoonents;

  public DisjoinSet(int size) {
    this.size = size;
    parent = new int[size];
    numCompoonents = size;

    for (int i = 0; i < size; i++) {
      parent[i] = -1;
    }
  }

  public boolean connected(int n0, int n1) {
    return find(n0) == find(n1);
  }

  public int find(int n) {
    if (parent[n] < 0) {
      return n;
    }
    return parent[n] = find(parent[n]);
  }

  public void union(int n0, int n1) {
    int p0 = find(n0);
    int p1 = find(n1);
    if (p0 == p1) {
      return;
    } else if (Math.abs(parent[p0]) > Math.abs(parent[p1])) {
      parent[p1] = p0;
    } else {
      parent[p0] = p1;
      parent[p1]--;
    }
    numCompoonents--;
  }

  public int getNumCompoonents() {
    return numCompoonents;
  }
}
