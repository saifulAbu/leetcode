# @param {Integer[][]} accounts
# @return {Integer}
def maximum_wealth(accounts)
  max_wealth = 0

  for account in accounts
    cur_wealth = account.sum
    max_wealth = cur_wealth if cur_wealth > max_wealth
  end

  max_wealth
end

acc = [[2,8,7],[7,1,3],[1,9,5]]
p maximum_wealth acc