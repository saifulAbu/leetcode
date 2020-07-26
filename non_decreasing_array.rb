# @param {Integer[]} nums
# @return {Boolean}
def check_possibility(nums)
  n = nums.size
  return true if n == 1
  modification_done = false
  for i in (1..(n-1))
    if nums[i-1] > nums[i]
      if modification_done
        return false
      else
        modification_done = true
      end
    end
  end
  return true
end

nums = [3, 4, 2, 3]
p check_possibility(nums)

nums = [4, 2, 1]
p check_possibility(nums)

=begin
may be on first pass make a modification
on second pass make sure it's ascending in nature
=end