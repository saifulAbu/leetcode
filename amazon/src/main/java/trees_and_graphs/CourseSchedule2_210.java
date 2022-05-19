package trees_and_graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2_210 {
  static public int[] findOrder(int numCourses, int[][] prerequisites) {
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
