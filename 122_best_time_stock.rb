# @param {Integer[]} prices
# @return {Integer}
def max_profit(prices)
  profit = 0
  can_buy = true
  size = prices.size

  prices << -Float::INFINITY

  0.upto(size - 1) do
    |i|
    if can_buy
      #buy
      if prices[i] < prices[i+1]
        profit -= prices[i]
        can_buy = false
      end
    else
      #sell
      if prices[i] > prices[i+1]
        profit += prices[i]
        can_buy = true
      end
    end
  end

  profit

end

puts max_profit [4, 5, 6, 7]