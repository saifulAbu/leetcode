package leetcode;

import java.util.List;

public class KeysAndRooms_841 {

  public boolean canVisitAllRooms(List<List<Integer>> keys) {
    boolean[] visited = new boolean[keys.size()];
    runDFSToSeeIfCanAllRooms(keys, visited, 0);
    return visitedAllRooms(visited);
  }

  private void runDFSToSeeIfCanAllRooms(List<List<Integer>> keys, boolean[] visited, int room) {
    visited[room] = true;
    for(Integer keyForRoom : keys.get(room)) {
      if(!visited[keyForRoom]) {
        runDFSToSeeIfCanAllRooms(keys, visited, keyForRoom);
      }
    }
  }

  private boolean visitedAllRooms(boolean[] visits) {
    for(boolean visit : visits) {
      if(!visit) {
        return false;
      }
    }
    return true;
  }
}

class KeysAndRooms_0_841 {
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
