package com.company;

import java.util.*;

public class ReconstructItinery {
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> graph = createGraph(tickets);
    List<String> path = new LinkedList<>();
    dfs(graph, path, "JFK");
    return path;
  }

  private void dfs(Map<String, PriorityQueue<String>> graph, List<String> path, String from) {
    PriorityQueue<String> dests = graph.get(from);
    if(dests == null) {
      path.add(0, from);
      return;
    }
    while(!dests.isEmpty()) {
      String to = dests.poll();
      dfs(graph, path, to);
    }
    path.add(0, from);
  }

  private Map<String, PriorityQueue<String>> createGraph(List<List<String>> tickets) {
    HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    for(List<String> ticket : tickets) {
      String to = ticket.get(0);
      String from = ticket.get(1);
      graph.putIfAbsent(to, new PriorityQueue<String>());
      graph.get(to).add(from);
    }
    return graph;
  }

  public static void main(String [] args) {
    List<List<String>> tickets = new LinkedList<>();
    tickets.add(Arrays.asList("MUC","LHR"));
    tickets.add(Arrays.asList("JFK","MUC"));
    tickets.add(Arrays.asList("SFO","SJC"));
    tickets.add(Arrays.asList("LHR","SFO"));

    ReconstructItinery ritin = new ReconstructItinery();
    List<String> path = ritin.findItinerary(tickets);
    return;
  }

}
