# @param {Integer} m
# @param {Integer} n
# @return {Integer}
def range_bitwise_and(m, n)
  return m if m == n
  result = 0;
  cur_bit = 1;
  mask = 2 ** (m.bit_length + 1) - 1

  while cur_bit <= m
    mask = mask ^ cur_bit
    #puts mask
    minimum_num_bit_flip = (m + cur_bit) & mask
    if minimum_num_bit_flip > n
      result = result | cur_bit
    end
    cur_bit = cur_bit * 2
  end
  result
end

p range_bitwise_and 3, 4