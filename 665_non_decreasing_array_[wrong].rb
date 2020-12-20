# @param {Integer[]} nums
# @return {Boolean}
def check_possibility(nums)
  n = nums.size
  return true if n < 3
  violation_count = 0

  if nums[0] > nums[1]
    nums[0] = nums[1]
    violation_count += 1
  end

  for i in (2..(n-1))
    b = nums[i-1]
    c = nums[i]
    if b > c
      violation_count += 1
      return false if violation_count > 1
      a = nums[i-2]
      if a <= c
        nums[i-1] = a
      else
        nums[i] = b
      end
    end
  end
  return false if violation_count > 1
  return true
end

nums = [5, 7, 1, 8]
p check_possibility(nums)

=begin
may be on first pass make a modification
on second pass make sure it's ascending in nature
=end
