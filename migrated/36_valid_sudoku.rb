require 'set'

# @param {Character[][]} board
# @return {Boolean}
def is_valid_sudoku(board)
  #check 3 x 3 squares
  for row_start in (0..6).step(3) do
    for col_start in (0..6).step(3) do
      set = Set.new
      for i in (0..2) do
        for j in (0..2) do
          cur_val = board[i+row_start][j+col_start]
          next if cur_val == "."
          return false if set.include? cur_val
          set.add cur_val
        end
      end
    end
  end

  # check rows
  for row in (0..8) do
    set = Set.new
    for col in (0..8) do
      cur_val = board[row][col]
      next if cur_val == "."
      return false if set.include? cur_val
      set.add cur_val
    end
  end

  # check columns
  for col in (0..8) do
      set = Set.new
      for row in (0..8) do
        cur_val = board[row][col]
        next if cur_val == "."
        return false if set.include? cur_val
        set.add cur_val
      end
    end
  true
end

valid = [
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]

invalid = [
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9",".",".",".",".",".","6","."],
  [".",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]

p is_valid_sudoku valid
p is_valid_sudoku invalid