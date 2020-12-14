# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
class BinaryMatrix
 	def initialize()
 	  @grid = [[0,0,0,0],
 	           [0,0,0,0],
 	           [0,1,1,1]]
 	end

 	def get(x, y)
 		@grid[x][y]
 	end

 	def dimensions()
 		[@grid.size, @grid[0].size]
 	end
end

# @param {BinaryMatrix} binaryMatrix
# @return {Integer}
def leftMostColumnWithOne(bm)
  row_len, col_len = bm.dimensions
  last_seen_one = -1
  cur_row = 0
  cur_col = col_len - 1

  while cur_row < row_len and cur_col >= 0
    if bm.get(cur_row, cur_col) == 1
      last_seen_one = cur_col
      cur_col -= 1
    else
      cur_row += 1
    end
  end

  last_seen_one
end

p leftMostColumnWithOne BinaryMatrix.new