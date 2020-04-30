def maximal_square(matrix)
  m = matrix.size
  return 0 if m == 0
  n = matrix[0].size
  return 0 if n == 0
  cur_max = 0
  max_size = [m, n].min

  dp = Array.new(m) {Array.new(n) {Array.new(max_size)}}
  for i in (0..(m-1)) do
    for j in (0..(n-1)) do
      if matrix[i][j] == 1
        dp[i][j][0] = 1
        cur_max = 1
      end
    end
  end

  for size in (2..max_size) do
    for i in (0..(m - size)) do
      for j in (0..(n - size)) do
        sz = size - 1
        if dp[i][j][sz-1] == 1 and dp[i+1][j][sz-1] == 1 and dp[i][j+1][sz-1] == 1 and dp[i+1][j+1][sz-1] == 1
          dp[i][j][sz] = 1
          cur_max = size if cur_max < size
        end
      end
    end
  end
  cur_max * cur_max
end

t = [
      [1,1],
      [1,1]
    ]
maximal_square t