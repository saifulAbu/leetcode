# @param {Character[][]} board
# @return {Void} Do not return anything, modify board in-place instead.
def solve(board)
  row_count = board.size
  return board if row_count == 0
  col_count = board[0].size

  visited = Array.new(row_count) { Array.new(col_count, true)}

  for r in (0..row_count-1)
    for c in (0..col_count-1)
      if board[r][c] == 'O'
        visited[r][c] = false
      end
    end
  end

  #first col, last col
  for r in (0..row_count-1)
    if !visited[r][0]
      dfs(r, 0, visited, board)
    end

    if !visited[r][col_count-1]
      dfs(r, col_count-1, visited, board)
    end
  end

  #first row, last row
  for c in (0..col_count-1)
    if !visited[0][c]
      dfs(0, c, visited, board)
    end

    if !visited[row_count-1][c]
      dfs(row_count-1, c, visited, board)
    end
  end

  for r in (0..row_count-1)
    for c in (0..col_count-1)
      if !visited[r][c]
        board[r][c] = 'X'
      end
    end
  end

  p board
end

def dfs(r, c, visited, board)
  row_count = board.size
  col_count = board[0].size
  visited[r][c] = true
  if(r + 1 < row_count and !visited[r+1][c])
    dfs(r+1, c, visited, board)
  end

  if(r - 1 >= 0 and !visited[r-1][c])
    dfs(r-1, c, visited, board)
  end

  if(c + 1 < col_count and !visited[r][c+1])
    dfs(r, c+1, visited, board)
  end

  if(c - 1 >= 0 and !visited[r][c-1])
    dfs(r, c-1, visited, board)
  end
end


board = [
        ['X', 'X', 'X', 'X'],
        ['X', 'O', 'X', 'X'],
        ['X', 'O', 'X', 'X'],
        ['X', 'O', 'X', 'O'],
        ['X', 'X', 'X', 'X']
        ]
solve []