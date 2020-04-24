# @param {Integer} m
# @param {Integer} n
# @return {Integer}
def range_bitwise_and(m, n)
  return m if m == n
  result = 0;
  cur_bit = 1;
  while cur_bit <= m
    if m + cur_bit > n
      result = result | cur_bit
    end
    cur_bit = cur_bit * 2
  end
  result
end

p range_bitwise_and 1, 1