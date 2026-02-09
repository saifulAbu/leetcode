package alpha_rep;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSrcToTarget_797 {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    /*
    * we will apply dfs on the graph
    * dfs(graph, curNode, curPath, allPath)
    *   curPath.addLast(curNode)
    *   targetNode = graph.len - 1;
    *   if(targetNode == curNode)
    *     allPath.add(curPath.copy())
    *   for(dst in graph[curNode])
    *     dfs(graph, dst, curPath, allPath)
    *   curPath.removeLast()
    *
    *  cost analysis:
    *   if we have currently k paths in a graph, if we add a new node, we can have 2k paths. just having all the k paths,
    *  plus adding the new node infront of the k paths. with each addition of path, we will multiply our count by 2.
    *  so there will be total of O(2 ^ n) paths. to build each paths, we have to do O(n) amount of work.
    *
    *  so total complexity is O(n * (2 ^ n)).
    *
    * */

    List<List<Integer>> allPaths = new LinkedList<>();
    dfs(graph, 0, new LinkedList<>(), allPaths);
    return allPaths;
  }

  private void dfs(int[][] graph, int curNode, LinkedList<Integer> curPath, List<List<Integer>> allPaths) {
    curPath.addLast(curNode);
    int targetNode = graph.length - 1;
    if(curNode == targetNode) {
      allPaths.add((List<Integer>) curPath.clone());
    }
    for(int nextNode : graph[curNode]) {
      dfs(graph, nextNode, curPath, allPaths);
    }
    curPath.removeLast();
  }

  public List<List<Integer>> allPathsSourceTarget_0(int[][] graph) {
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
