# @param {Integer[][]} matrix
# @return {Void} Do not return anything, modify matrix in-place instead.
def rotate(matrix)
  return if matrix.empty?
  n = matrix.size

  #roate layer by layer
  for start in (0..(n/2)) do
    cur_n = n - 2 * start
    break if cur_n < 1
    max = start + cur_n - 1 # max row or column
    #puts "start:#{start}, cur_n:#{cur_n}"
    for col in (start..(max - 1)) do
      row0 = start
      col0 = col
      val0 = matrix[row0][col0]

      # number of elements between row0, col0 and row1, col1 would be N, same goes for other pairs
      # adjust row, column appropriately
      col1 = max
      offset = col1 - col0 + 1
      more = cur_n - offset
      row1 = start + more
      val1 = matrix[row1][col1]

      row2 = max
      offset = (row2 - row1) + 1
      more = cur_n - offset
      col2 = max - more
      val2 = matrix[row2][col2]

      col3 = start
      offset = col2 - col3 + 1
      more = cur_n - offset
      row3 = max - more
      val3 = matrix[row3][col3]

      #puts "[#{row0},#{col0}] [#{row1},#{col1}] [#{row2},#{col2}] [#{row3},#{col3}]"
      matrix[row0][col0] = val3
      matrix[row1][col1] = val0
      matrix[row2][col2] = val1
      matrix[row3][col3] = val2
    end
  end
  matrix
end

matrix0 =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
]

matrix1 =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
]

p rotate matrix0