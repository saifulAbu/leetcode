package trees_and_graphs;

import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSrcToTarget_797 {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
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
