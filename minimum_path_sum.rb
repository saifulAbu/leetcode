# @param {Integer[][]} grid
# @return {Integer}
def min_path_sum(grid)
  cost = []
  row_len = grid.size
  col_len = grid[0].size

  for r in 0..(row_len - 1) do
    row = Array.new(col_len) {Float::INFINITY}
    cost << row
  end

  queue = Queue.new
  queue.enq [grid[0][0], 0, 0]
  until queue.empty?
    elem = queue.deq
    cur_cost = elem[0]
    r = elem[1]
    c = elem[2]
    if cost[r][c] > cur_cost
      cost[r][c] = cur_cost

      #enq child to the right
      if c + 1 < col_len
        cost_to_child = cur_cost + grid[r][c+1]
        if cost[r][c+1] > cost_to_child
          queue.enq [cost_to_child, r, c+1]
        end
      end

      #enq child to the right
      if r + 1 < row_len
        cost_to_child = cur_cost + grid[r+1][c]
        if cost[r+1][c] > cost_to_child
          queue.enq [cost_to_child, r+1, c]
        end
      end
    end
  end

  cost[-1][-1]
end

sample =  [
            [1,3,1],
            [1,5,1],
            [4,2,1]
          ]

p min_path_sum sample