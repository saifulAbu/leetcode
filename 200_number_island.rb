# @param {Character[][]} grid
# @return {Integer}
def num_islands(grid)
  row_len = grid.size
  return 0 if row_len == 0
  col_len = grid[0].size
  grid_size = row_len * col_len
  return 0 if grid_size == 0

  dsf = Array.new(grid_size)

  # initialize disjoint set forest
  for i in (0..(row_len - 1)) do
    for j in (0..(col_len - 1)) do
      index = get_dsf_index(i, j, col_len)
      grid[i][j] = grid[i][j].to_i
      if grid[i][j] == 1
        dsf[index] = -1
      else
        dsf[index] = -2
      end
    end
  end

  #union on row 0
  for col in 1..(col_len - 1) do
    if grid[0][col-1] == 1 and grid[0][col] == 1
      index_prev = get_dsf_index(0, col-1, col_len)
      index_cur = get_dsf_index(0, col, col_len)
      union(dsf, index_prev, index_cur)
    end
  end

  #union on col 0
  for row in 1..(row_len - 1) do
    if grid[row][0] == 1 and grid[row-1][0] == 1
      index_prev = get_dsf_index(row-1, 0, col_len)
      index_cur = get_dsf_index(row, 0, col_len)
      union(dsf, index_prev, index_cur)
    end
  end

  #union rest of the stuffs
  for row in 1..(row_len - 1) do
    for col in 1..(col_len - 1) do
      if grid[row][col] == 1
        #check element left
        if grid[row][col-1] == 1
          index_prev = get_dsf_index(row, col-1, col_len)
          index_cur = get_dsf_index(row, col, col_len)
          union(dsf, index_prev, index_cur)
        end

        #check element above
        if grid[row-1][col] == 1
          index_prev = get_dsf_index(row-1, col, col_len)
          index_cur = get_dsf_index(row, col, col_len)
          union(dsf, index_prev, index_cur)
        end
      end
    end
  end

  count_island = 0
  dsf.each do
    |elem|
    count_island += 1 if elem == -1
  end
  count_island
end

def get_dsf_index(row, col, col_len)
  row * col_len + col
end

def find(dsf, a)
  if dsf[a] == -1
    return a
  else
    root_a = dsf[a]
    return find(dsf, root_a)
  end
end

def in_same_set(dsf, a, b)
  root_a = find(dsf, a)
  root_b = find(dsf, b)
  root_a == root_b
end

def union(dsf, a, b)
  ra = find(dsf, a)
  rb = find(dsf, b)
  dsf[rb] = ra if ra != rb
end

env =  [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]

#puts total_size env
p num_islands env