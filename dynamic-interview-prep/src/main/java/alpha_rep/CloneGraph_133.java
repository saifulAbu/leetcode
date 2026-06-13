package alpha_rep;

import java.util.*;

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

  public Node cloneGraph(Node node) {
    HashMap<Node, Node> cloneMap = new HashMap<>();
    cloneMap.put(node, new Node(node.val));
    dfs_3_2(node, cloneMap);

    return cloneMap.get(node);
  }

  private void dfs_3_2(Node node, HashMap<Node, Node> cloneMap) {
    for(Node neighbor : node.neighbors) {
      if(!cloneMap.containsKey(neighbor)) {
        cloneMap.put(neighbor, new Node(neighbor.val));
        dfs_3_2(neighbor, cloneMap);
      }
      cloneMap.get(node).neighbors.add(cloneMap.get(neighbor));
    }
  }

  //before calling this method, add node to seenNodes
  private void exploreNodesUsingDFS(Node node, HashSet<Node> seenNodes) {
    for(Node neighbor : node.neighbors) {
      if(!seenNodes.contains(neighbor)) {
        seenNodes.add(neighbor);
        exploreNodesUsingDFS(neighbor, seenNodes);
      }
    }
  }

  private HashMap<Integer, Node> createDupNodes(HashSet<Node> seenNodes) {
    HashMap<Integer, Node> dupNodeMap = new HashMap<>();
    for(Node node : seenNodes) {
      int nodeId = node.val;
      dupNodeMap.put(nodeId, new Node(nodeId));
    }
    return dupNodeMap;
  }

  private void connectDupNodes(HashSet<Node> seenNodes, HashMap<Integer, Node> dupNodesMap) {
    for(Node origNode : seenNodes) {
      Node dupNode = dupNodesMap.get(origNode.val);
      for(Node origNeighbor : origNode.neighbors) {
        Node dupNeighbor = dupNodesMap.get(origNeighbor.val);
        dupNode.neighbors.add(dupNeighbor);
      }
    }
  }

  public Node cloneGraph_0(Node node) {
    // base checks
    if(node == null) {
      return null;
    }

    HashSet<Node> seenNodes = new HashSet<>();
    // explore the nodes
    seenNodes.add(node);
    exploreNodesUsingDFS(node, seenNodes);

    // create dup map based on the seenNodes
    HashMap<Integer, Node> dupNodesMap = createDupNodes(seenNodes);

    // fillup the dup leetcode.graph using the map and nodes in seenNodes connection
    connectDupNodes(seenNodes, dupNodesMap);

    //return dup Node 1
    return dupNodesMap.get(1);
  }
}

class CloneGraph_0_133 {
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

  public Node cloneGraph_drona(Node node) {
    Map<Node, Node> clone = new HashMap<>();
    dfs_drona(node, clone);
    return clone.get(node);
  }

  private void dfs_drona(Node node, Map<Node, Node> cloneMap) {
    if(cloneMap.containsKey(node)) {
      return;
    }
    Node clone = new Node(node.val);
    cloneMap.put(node, clone);
    for(Node neighbor : node.neighbors) {
      dfs_drona(neighbor, cloneMap);
      Node neighborClone = cloneMap.get(neighbor);
      clone.neighbors.add(neighborClone);
    }
  }
}
