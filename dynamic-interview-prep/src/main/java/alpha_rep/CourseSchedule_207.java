package alpha_rep;

import java.util.*;

public class CourseSchedule_207 {
  public boolean canFinish_drona(int numCourses, int[][] prerequisites) {
    // adjacency list
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    // indegree array
    int[] indegree = new int[numCourses];

    // build graph
    for (int[] p : prerequisites) {
      int course = p[0];
      int prereq = p[1];
      adj.get(prereq).add(course);
      indegree[course]++;
    }

    // queue of all nodes with indegree 0
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    int processed = 0;

    // BFS topological sort
    while (!q.isEmpty()) {
      int cur = q.poll();
      processed++;

      for (int next : adj.get(cur)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          q.offer(next);
        }
      }
    }

    // if we processed all courses, no cycle exists
    return processed == numCourses;
  }

  public boolean canFinish_0(int numCourses, int[][] prerequisites) {
    /*
     * we will use topological sorting
     * courseTakenCount = 0;
     *
     * // build inDegree
     * indegree = new int[N]
     * // build graph
     * List<Integer>[] graph = new List<>[N];
     * for(preReq : preReqs)
     * dependendCourse = preReq[0]
     * independendCourse = preReq[1]
     * indegree[dependendCourse]++;
     * if(graph[indepCourse] == null)
     * graph[indepCourse] = new List<>
     * graph[indep].add(dst)
     * end for
     *
     * q = new queue
     * taken = 0
     * while(!q.isEmpty() && taken < numCourses)
     * curCourse = q.poll()
     * taken++
     * for(nextCourse : graph[curCourse])
     * indegree[nextCourse]--
     * if(indegree[nextCourse] == 0)
     * q.add(nextCourse)
     *
     * return takenCount == numCourses;
     *
     */

    // build graph and indegree
    int[] indegrees = new int[numCourses];
    List<Integer>[] graph = new List[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int[] requisite : prerequisites) {
      int childCourse = requisite[0], parentCourse = requisite[1];
      indegrees[childCourse]++;
      graph[parentCourse].add(childCourse);
    }

    Deque<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) {
        q.offer(i);
      }
    }

    int totalCourseTaken = 0;
    while (!q.isEmpty() && totalCourseTaken < numCourses) {
      int curCourse = q.poll();
      totalCourseTaken++;

      for (int depCourse : graph[curCourse]) {
        indegrees[depCourse]--;
        if (indegrees[depCourse] == 0) {
          q.offer(depCourse);
        }
      }
    }

    return totalCourseTaken == numCourses;
  }

  public boolean canFinish_3_2(int numCourses, int[][] prerequisites) {
    // create adjacency list
    ArrayList<Integer>[] adjList = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      adjList[i] = new ArrayList<>();
    }

    int[] indegree = new int[numCourses];
    for (int[] prereq : prerequisites) {
      int src = prereq[1], dest = prereq[0];
      adjList[src].add(dest);
      indegree[dest]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int courseScheduled = 0;
    while (!q.isEmpty()) {
      int curCourse = q.poll();
      courseScheduled++;
      if (courseScheduled > numCourses) {
        return false;
      }

      for (int depCourse : adjList[curCourse]) {
        indegree[depCourse]--;
        if (indegree[depCourse] == 0) {
          q.add(depCourse);
        }
      }
    }

    return courseScheduled == numCourses;
  }

  public boolean canFinish_0530(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new ArrayList<>());
    }

    int[] indegree = new int[numCourses];
    for (int[] edge : prerequisites) {
      int src = edge[1];
      int dst = edge[0];
      graph.get(src).add(dst);
      indegree[dst]++;
    }

    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    int processed = 0;
    while (!q.isEmpty()) {
      int src = q.poll();
      processed++;

      for (int dst : graph.get(src)) {
        indegree[dst]--;
        if (indegree[dst] == 0) {
          q.offer(dst);
        }
      }
    }

    return processed == numCourses;
  }

  public boolean canFinish_0614(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    int[] indegree = new int[numCourses];
    for (int[] preReq : prerequisites) {
      int depCourse = preReq[0];
      int preReqCourse = preReq[1];
      indegree[depCourse]++;
      graph.get(preReqCourse).add(depCourse);
    }

    Queue<Integer> preReqCourses = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        preReqCourses.add(i);
      }
    }

    int processed = 0;
    while (!preReqCourses.isEmpty()) {
      int eligibleCourse = preReqCourses.poll();
      processed++;
      for (int course : graph.get(eligibleCourse)) {
        indegree[course]--;
        if (indegree[course] == 0) {
          preReqCourses.add(course);
        }
      }
    }

    return processed == numCourses;
  }

  public boolean canFinish_0714(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    List<Integer>[] graph = new List[numCourses];
    for(int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<>();
    }

    // build graph and indegree
    for(int[] edge : prerequisites) {
      int dst = edge[0];
      int src = edge[1];
      graph[src].add(dst);
      indegree[dst]++;
    }

    // run bfs to see if we can process all the courses
    int processed = 0;
    Queue<Integer> q = new LinkedList<>();
    for(int i  = 0; i < numCourses; i++) {
      if(indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty() && processed != numCourses) {
      int src = q.poll();
      for(int dst : graph[src]) {
        indegree[dst]--;
        if (indegree[dst] == 0) {
          q.add(dst);
        }
      }
      processed++;
    }

    return processed == numCourses;
  }
}
