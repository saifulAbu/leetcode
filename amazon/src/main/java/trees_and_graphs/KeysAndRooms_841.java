package trees_and_graphs;

import java.util.List;

public class KeysAndRooms_841 {
  boolean[] visited;
  List<List<Integer>> rooms;
  int visitedCount = 0;
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    this.rooms = rooms;
    visited = new boolean[rooms.size()];
    dfs(0);
    return visitedCount == visited.length;
  }

  private void dfs(int r) {
    visited[r] = true;
    visitedCount++;
    for (int neighbor : rooms.get(r)) {
      if(!visited[neighbor]) {
        dfs(neighbor);
      }
    }
  }
}
