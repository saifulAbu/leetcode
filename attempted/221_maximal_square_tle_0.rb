def maximal_square(matrix)
  m = matrix.size
  return 0 if m == 0
  n = matrix[0].size
  return 0 if n == 0
  cur_max = 0
  max_size = [m, n].min
  for size in (1..max_size) do
    found_valid_sqr = false
    for start_row in (0..(m - size)) do
      for start_col in (0..(n - size)) do
        is_valid = true
        for i in (start_row..(start_row + size - 1)) do
          for j in (start_col..(start_col + size - 1)) do
            if matrix[i][j] == "0"
              is_valid = false
              break
            end
            break if is_valid == false
          end
        end
        if is_valid
          found_valid_sqr = true
          break
        end
      end
      break if found_valid_sqr
    end
    if found_valid_sqr
      cur_max = size
    end
  end
  cur_max * cur_max
end
