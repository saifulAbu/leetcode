# @param {Integer} amount
# @param {Integer[]} coins
# @return {Integer}
def change(amount, coins)
  return 1 if amount == 0

  dp = Array.new(coins.size + 1) { Array.new(amount + 1)}

  for i in (0..(coins.size)) do
    dp[i][0] = 1
  end

  for j in (1..amount) do
    dp[0][j] = 0
  end

  p dp

  for i in (1..coins.size) do
    for j in (1..amount) do
      dp[i][j] = 0
      dp[i][j] = dp[i][j-coins[i-1]] if j-coins[i-1] >= 0
      dp[i][j] += dp[i-1][j]
    end
  end

  dp[i][j]
end

amount = 6
coins = [1, 2, 5]

p change(amount, coins)