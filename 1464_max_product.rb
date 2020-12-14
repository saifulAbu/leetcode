# @param {Integer[]} nums
# @return {Integer}
def max_product(nums)
  n = nums.size
  max = -Float::INFINITY
  for i in (0..(n-2)) do
    for j in ((i+1)..(n-1)) do
      x = nums[i] - 1
      y = nums[j] - 1
      prod = x * y
      max = prod if prod > max
    end
  end
  max
end

nums = [3,4,5,2]
p max_product nums