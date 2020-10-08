# @param {Integer[]} nums
# @return {Void} Do not return anything, modify nums in-place instead.
def sort_colors(nums)
  count_0 = 0
  count_1 = 0
  count_2 = 0

  for elem in nums
    case elem
    when 0
      count_0 += 1
    when 1
      count_1 += 1
    when 2
      count_2 += 1
    end
  end

  # store 0
  for i in (0..count_0-1) do
    nums[i] = 0
  end

  # store 1
  for i in (count_0..count_0+count_1 - 1) do
    nums[i] = 1
  end
  # store 2
  for i in (count_0+count_1 .. count_0+count_1+count_2 - 1) do
    nums[i] = 2
  end

  nums
end

nums = [2,0,2, 1]
p sort_colors nums