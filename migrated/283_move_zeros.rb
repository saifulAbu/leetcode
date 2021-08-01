# @param {Integer[]} nums
# @return {Void} Do not return anything, modify nums in-place instead.
def move_zeroes(nums)
  size = nums.size
  return nums if size < 2

  index_zero = 0
  index_num = 0

  while true
    while index_zero < size
      break if nums[index_zero] == 0
      index_zero += 1
    end
    break if index_zero >= size

    while index_num < size
      break if nums[index_num] != 0 and index_num > index_zero
      index_num += 1
    end
    break if index_num >= size

     #swap
    nums[index_zero] = nums[index_num]
    nums[index_num] = 0
  end

  return nums
end


p move_zeroes [0,1]