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

  cost[0][0] = grid[0][0]
  # fill column 0
  for row in 1..(row_len - 1) do
    cost[row][0] = cost[row-1][0] + grid[row][0]
  end

  # fil row 0
  for col in 1..(col_len - 1) do
    cost[0][col] = cost[0][col-1] + grid[0][col]
  end

  for row in 1..(row_len - 1) do
    for col in 1..(col_len - 1) do
      min_parent = [cost[row-1][col], cost[row][col-1]].min
      cost[row][col] = grid[row][col] + min_parent
    end
  end
  cost[-1][-1]
  #cost
end

sample =  [
            [1,3,1],
            [1,5,1],
            [4,2,1]
          ]

p min_path_sum sample