require 'pry'
require 'pry-nav'

# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def subarray_sum(nums, k)
  len = nums.size
  count = 0
  for i in (0..(len - 1)) do
    sum = 0
    for j in (i..(len - 1)) do
      sum += nums[j]
      count += 1 if sum == k
    end
  end
  count
end

arr = [1, 1, 1]

p subarray_sum arr, 2