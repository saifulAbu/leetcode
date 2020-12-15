require 'pry'
require 'pry-nav'

# @param {Integer} n
# @return {Integer}
def num_squares(n)
  dp = Array.new(n+1) {|i| i}

  sqrs = []
  for i in (1..Math.sqrt(n))
    sqrs << i * i
    dp[i*i] = 1
  end

  return 1 if dp[n] == 1

  for i in (2..n)
    next if dp[i] == 1
    for j in (0..(sqrs.size - 1))
      remaining = i - sqrs[j]
      break if remaining < 0
      cur_sqrs = dp[remaining] + 1
      dp[i] = [dp[i], cur_sqrs].min
    end
  end
  dp[n]
end

p num_squares 13