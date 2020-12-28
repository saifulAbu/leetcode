# @param {Integer} n
# @return {Integer}
def arrange_coins(n)
  res = 0
  i = 1
  while i <= n
    res += 1
    n -= i
    i += 1
  end
  return res
end

p arrange_coins 10