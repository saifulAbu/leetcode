# @param {Integer} num_courses
# @param {Integer[][]} prerequisites
# @return {Boolean}
def can_finish(num_courses, prerequisites)
  graph = Array.new(num_courses) {[]}

  for pairs in prerequisites
    crs = pairs[0]
    preq = pairs[1]
    graph[preq].append(crs)
  end

  indegree = Array.new(num_courses) {0}

  for neighbors in graph do
    for neighbor in neighbors do
      indegree[neighbor] += 1
    end
  end

  queue = Queue.new
  for i in 0..(num_courses-1) do
    queue.enq(i) if indegree[i] == 0
  end

  courses_taken = 0
  until queue.empty?
    cur_course = queue.deq
    courses_taken += 1
    for depended_course in graph[cur_course]
      indegree[depended_course] -= 1
      queue.enq depended_course if indegree[depended_course] == 0
    end
  end

  if courses_taken == num_courses
    return true
  else
    return false
  end
end

p can_finish(4, [[1,0], [2, 0], [3, 1], [3, 2], [0, 3]])