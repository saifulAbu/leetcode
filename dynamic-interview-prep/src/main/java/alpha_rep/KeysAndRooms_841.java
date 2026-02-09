package alpha_rep;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KeysAndRooms_841 {

  public boolean canVisitAllRooms(List<List<Integer>> keys) {
    /*
    * we will use BFS to solve this problem
    * we will maintain a queue that will have keys at hand
    * q.offer(0)
    * while(!q.isEmpty() && totalSeen < keys.Length()) {
    *   curkey = q.poll()
    *   if(seen[curkey])
    *     continue;
    *   seen[curkey] = true;
    *   totalSeen++;
    *   //push all the keys in the current room
    *   for(key : keys.get(curKey))
    *     q.offer(key)
    * }
    * return totalSeen = KeysCount;
    *
    * */

    int KEY_COUNT = keys.size();
    boolean[] usedKey = new boolean[KEY_COUNT];

    Deque<Integer> keyAtHand = new LinkedList<>();
    keyAtHand.addFirst(0);
    int totalKeyUsed = 0;

    while(!keyAtHand.isEmpty() && totalKeyUsed < KEY_COUNT) {
      int curKey = keyAtHand.pollFirst();
      if(usedKey[curKey]) {
        continue;
      }
      usedKey[curKey] = true;
      totalKeyUsed++;

      for(int newKey : keys.get(curKey)) {
        keyAtHand.offer(newKey);
      }
    }

    return totalKeyUsed == KEY_COUNT;
  }

  public boolean canVisitAllRooms_0(List<List<Integer>> keys) {
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
