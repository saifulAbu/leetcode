package alpha_rep;

import java.util.*;

public class CourseSchedule2_210 {

  /*
  * classic topological sort problem
  * we are given a list of edges
  *
  * implement the following
  * buildAdjGraph
  * getInDegree
  * runTopologicalSort
  * */

  public int[] findOrder_drona(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    int[] indegree = new int[numCourses];

    // Build graph
    for (int[] p : prerequisites) {
      int course = p[0];
      int prereq = p[1];
      adj.get(prereq).add(course);
      indegree[course]++;
    }

    // Queue of all nodes with indegree 0
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    int[] order = new int[numCourses];
    int idx = 0;

    // BFS Topological Sort
    while (!q.isEmpty()) {
      int cur = q.poll();
      order[idx++] = cur;

      for (int next : adj.get(cur)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          q.offer(next);
        }
      }
    }

    // If we processed all courses, return order
    if (idx == numCourses) {
      return order;
    }

    // Cycle detected
    return new int[0];
  }


  static public int[] findOrder0(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = getAdjList(numCourses, prerequisites);
    int[] indegs = getIndegree(graph);
    Queue<Integer> q = new ArrayDeque<>();
    for(int i = 0; i < numCourses; i++) {
      if(indegs[i] == 0) {
        q.offer(i);
      }
    }
    ArrayList<Integer> courseOrder = new ArrayList<>();
    while(!q.isEmpty()) {
      int curCrs = q.poll();
      courseOrder.add(curCrs);
      for(int depCrs : graph[curCrs]) {
        indegs[depCrs]--;
        if (indegs[depCrs] == 0) {
          q.offer(depCrs);
        }
      }
    }
    if(courseOrder.size() == numCourses) {
      return courseOrder.stream().mapToInt(i -> i).toArray();
    }
    return new int[0];
  }

  static private int[] getIndegree(List[] graph) {
    int [] inDegree = new int[graph.length];
    for(List<Integer> depCrsList : graph) {
      for(int depCrs : depCrsList) {
        inDegree[depCrs]++;
      }
    }
    return inDegree;
  }

  static private List<Integer>[] getAdjList(int n, int[][] preReqs) {
    List<Integer>[] graph = new List[n];
    for(int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for(int [] req : preReqs) {
      int depCrs = req[0];
      int preReq = req[1];
      graph[preReq].add(depCrs);
    }
    return graph;
  }

  public static void main(String [] str) {
    int [][] edges = {
            {1, 0}, {2, 0}, {2, 1}, {3, 2}
           // {1, 0}, {2, 1}, {3, 2}
    };
    List[] graph = getAdjList(4, edges);
    int[] inDeg = getIndegree(graph);
    System.out.println();
  }
}
