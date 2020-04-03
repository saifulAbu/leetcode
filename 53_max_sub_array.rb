# @param {Integer[]} nums
# @return {Integer}
def max_sub_array(nums)
  max_sum = -Float::INFINITY
  cur_sum = 0

  nums.each do
    |num|
    cur_sum = cur_sum + num
    max_sum = cur_sum if cur_sum > max_sum
    cur_sum = 0 if cur_sum < 0
  end

  max_sum
end

puts max_sub_array [-2,1,-3,4,-1,2,1,-5,4]