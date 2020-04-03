require 'set'

# @param {Integer} n
# @return {Boolean}
def is_happy(n)
  num_set = Set.new

  num = n
  count = 0
  while true
    next_num = 0
    while num > 0
      digit = num % 10
      num /= 10
      next_num = next_num + (digit * digit)
    end
    return false if num_set.include? next_num
    return true if next_num == 1
    num_set.add next_num
    num = next_num
  end
end

puts is_happy 1111111

=begin

sqr_num = Set.new
num = n

while true
  next_num = 0
  while num > 0
    digit = num % 10
    num /= 10
    next_num += (digit * digit)
  end
  return false if sqr_num.contains? next_num
  return true if next_num == 1
  num = next_num
end

=end