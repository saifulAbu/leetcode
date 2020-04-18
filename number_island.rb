# @param {Character[][]} grid
# @return {Integer}
def num_islands(grid)
  size = total_size(grid)
  return 0 if size == 0
  row_len = grid.size
  col_len = grid[0].size
  grid_size = row_len * col_len

  dis_set = Array.new(grid_size)

  for i in (0..(row_len - 1)) do
    for j in (0..(col_len - 1)) do
      index = i * col_len + j
      if grid[i][j] == 1
        dis_set[index] = -1
      else
        dis_set[index] = -2
      end
    end
    puts
  end
end

def total_size(grid)
  size = 0
  grid.each do
    |row|
    size += row.size
  end
  size
end

env =  [
        [1,1,0,0,0],
        [1,1,0,0,0],
        [0,0,1,0,0],
        [0,0,0,1,1]
       ]

#puts total_size env
num_islands env