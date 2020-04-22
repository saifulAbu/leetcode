require 'pry'
require 'pry-nav'

# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def subarray_sum(nums, k)
  len = nums.size
  front = 0
  back = 0
  cur_sum = 0
  count = 0

  #binding.pry
  while front < len and back < len do
    if cur_sum == k
      cur_sum -= nums[back]
      back += 1
    elsif cur_sum > k
      cur_sum -= nums[back]
      back += 1
    else
      cur_sum += nums[front]
      front += 1
    end

    count += 1 if cur_sum == k
  end

  if front == len
    while back < len
      cur_sum -= nums[back]
      back += 1
      count += 1 if cur_sum == k
    end
  end

  count
end

arr = [1, 1, 1]

p subarray_sum arr, 2