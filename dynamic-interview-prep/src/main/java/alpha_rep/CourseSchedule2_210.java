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

  int[] findOrder(int numCourses, int[][] prerequisites) {
    //build graph and in degree
    List<Integer>[] graph = new List[numCourses];
    int[] inDegree = new int[numCourses];

    for(int i = 0; i < numCourses; i++) {
      graph[i] = new LinkedList<>();
    }

    for(int[] edge : prerequisites) {
      int dst = edge[0], src = edge[1];
      graph[src].add(dst);
      inDegree[dst]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < numCourses; i++) {
      if(inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int[] courseOrder = new int[numCourses];
    int orderedCourseCount = 0;

    while(!queue.isEmpty()) {
      int curCourse = queue.poll();
      // exceeding course count, one course that has been processed is coming again, might be a cycle
      if(orderedCourseCount == numCourses) {
        return new int[0];
      }
      courseOrder[orderedCourseCount++] = curCourse;
      for(int dst : graph[curCourse]) {
        inDegree[dst]--;
        if(inDegree[dst] == 0) {
          queue.add(dst);
        }
      }
    }

    if(orderedCourseCount == numCourses) {
      return courseOrder;
    } else {
      return new int[0];
    }
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
