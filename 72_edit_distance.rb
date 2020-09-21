# @param {String} word1
# @param {String} word2
# @return {Integer}
def min_distance(src, dest)
  dp = Array.new(src.size + 1) { Array.new(dest.size + 1) }
  dp[0][0] = 0

  for i in (1..src.size) do
    dp[i][0] = dp[i-1][0] + 1
  end

  for j in (1..dest.size) do
    dp[0][j] = dp[0][j-1] + 1
  end

  for i in (1..src.size) do
    for j in (1..dest.size) do
      if(src[i-1] == dest[j-1])
        dp[i][j] = dp[i-1][j-1]
      else
        dp[i][j] = [dp[i-1][j-1], dp[i-1][j], dp[i][j-1]].min + 1
      end
    end
  end
  p dp
  dp[src.size][dest.size]
end

def min_distance_recursive(src, dest)
  if(src.empty? and dest.empty?)
    return 0
  end

  if(src.empty?)
    return dest.size
  end

  if(dest.empty?)
    return src.size
  end

  if(src[-1] == dest[-1])
    return min_distance_recursive(src.chop, dest.chop)
  else
    delete = min_distance_recursive(src.chop, dest)
    insert = min_distance_recursive(src, dest.chop)
    replace = min_distance_recursive(src.chop, dest.chop)
    return [delete, insert, replace].min + 1
  end
end

p min_distance("melinda", "saif")