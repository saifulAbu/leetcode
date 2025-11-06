package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSrcToTarget_797 {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int N = graph.length, target = N - 1, source = 0;
    List<List<Integer>> paths = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    path.add(source);
    Queue<List<Integer>> q = new LinkedList<>();
    q.offer(path);

    while(!q.isEmpty()) {
      List<Integer> curPath = q.poll();
      int curNode = curPath.get(curPath.size() - 1);
      if(curNode == target) {
        paths.add(curPath);
        continue;
      }
      for(int neighbor : graph[curNode]) {
        List<Integer> neighborPath = new LinkedList<>(curPath);
        neighborPath.add(neighbor);
        q.offer(neighborPath);
      }
    }
    return paths;
  }

  public List<List<Integer>> allPathsSourceTarget0(int[][] graph) {
    int [] seen = new int[graph.length];
    List<List<Integer>> paths = new LinkedList<>();
    dfs(0, graph, seen, new LinkedList<>(), paths);
    return paths;
  }

  private void dfs(int curNode, int[][] graph, int [] seen, List<Integer> curPath, List<List<Integer>> paths) {
    seen[curNode] = 1;
    curPath.add(curNode);
    if (curNode == seen.length - 1) {
      paths.add(new LinkedList<>(curPath));
    } else {
      int [] neighbors = graph[curNode];
      for (int i : neighbors) {
        if (i == curNode || seen[i] == 1) {
          continue;
        }
        dfs(i, graph, seen, curPath, paths);
      }
    }
    seen[curNode] = 0;
    curPath.remove(curPath.size() - 1);
  }
}
