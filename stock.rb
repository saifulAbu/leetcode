# @param {Integer[]} prices
# @return {Integer}
def max_profit(prices)
  m_profit = 0

  size = prices.size

  for interval in (1..(size-1)) do
    0.upto(size - interval - 1) do
      |start|
        end_day = start + interval
        cur_profit = prices[end_day] - prices[start]
        m_profit += cur_profit if cur_profit > 0
    end
    m_profit += cur_profit if cur_profit > 0
  end

  m_profit

end

puts max_profit [7,1,5,3,6,4]