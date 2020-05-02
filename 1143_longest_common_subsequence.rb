# @param {String} text1
# @param {String} text2
# @return {Integer}
def longest_common_subsequence(text1, text2)
  m = text1.size
  n = text2.size
  return 0 if m == 0 or n == 0

  dp = Array.new(m+1) {Array.new(n+1) {0}}

  1.upto(m) do
    |i|
    1.upto(n) do
      |j|
      a = dp[i-1][j]
      b = dp[i][j-1]
      c = dp[i-1][j-1] + (text1[i-1] == text2[j-1]? 1 : 0)
      dp[i][j] = [a, b, c].max
    end
  end
  dp[m][n]
end


text1 = "abcd"
text2 = "acdf"

p longest_common_subsequence text1, text2