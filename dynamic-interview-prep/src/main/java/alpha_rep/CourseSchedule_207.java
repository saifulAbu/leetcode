package alpha_rep;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule_207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    /*
    * we will use topological sorting
    * courseTakenCount = 0;
    *
    * // build inDegree
    * indegree = new int[N]
    * // build graph
    * List<Integer>[] graph = new List<>[N];
    * for(preReq : preReqs)
    *   dependendCourse = preReq[0]
    *   independendCourse = preReq[1]
    *   indegree[dependendCourse]++;
    *   if(graph[indepCourse] == null)
    *     graph[indepCourse] = new List<>
        graph[indep].add(dst)
    * end for
    *
    * q = new queue
    * taken = 0
    * while(!q.isEmpty() && taken < numCourses)
    *   curCourse = q.poll()
    *   taken++
    *   for(nextCourse : graph[curCourse])
    *     indegree[nextCourse]--
    *     if(indegree[nextCourse] == 0)
    *       q.add(nextCourse)
    *
    * return takenCount == numCourses;
    *
    * */

    //build graph and indegree
    int[] indegrees = new int[numCourses];
    List<Integer>[] graph = new List[numCourses];
    for(int i = 0; i < numCourses; i++) {
        graph[i] = new LinkedList<>();
    }

    for(int[] requisite : prerequisites) {
      int childCourse = requisite[0], parentCourse = requisite[1];
      indegrees[childCourse]++;
      graph[parentCourse].add(childCourse);
    }

    Deque<Integer> q = new LinkedList<>();
    for(int i = 0; i < numCourses; i++) {
      if(indegrees[i] == 0) {
        q.offer(i);
      }
    }

    int totalCourseTaken  = 0;
    while(!q.isEmpty() && totalCourseTaken < numCourses) {
      int curCourse = q.poll();
      totalCourseTaken++;

      for(int depCourse : graph[curCourse]) {
        indegrees[depCourse]--;
        if(indegrees[depCourse] == 0) {
          q.offer(depCourse);
        }
      }
    }

    return totalCourseTaken == numCourses;
  }
}
