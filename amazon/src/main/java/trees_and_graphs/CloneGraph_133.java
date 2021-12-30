package trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133 {
  private static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  HashMap<Integer, Node> graph = new HashMap<>();
  public Node cloneGraph(Node node) {
    if(node == null) {
      return node;
    }
    dfs(node);
    return graph.get(node.val);
  }

  private void dfs(Node node) {

    int val = node.val;
    ArrayList<Node> clonedNeighbors = new ArrayList<>();
    graph.put(val, new Node(val, clonedNeighbors));
    for (Node neighbor : node.neighbors) {
      if (!graph.containsKey(neighbor.val)) {
        dfs(neighbor);
      }
      clonedNeighbors.add(graph.get(neighbor.val));
    }
  }
}
