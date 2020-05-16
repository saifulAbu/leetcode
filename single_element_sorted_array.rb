# @param {Integer[]} nums
# @return {Integer}
def single_non_duplicate(nums)
  return nums[0] if nums.size == 1
  s = 0
  e = nums.size - 1

  begin
    m = (s + e) / 2
    first = m
    second = m
    if nums[m] == nums[m+1]
      first = m
      second = m + 1
    elsif nums[m-1] == nums[m]
      first = m - 1
      second = m
    end
    return nums[m] if first == second

    if first % 2 == 0
      s = second + 1
    else
      e = first - 1
    end
  end while s <= e
end

nums = [2, 2, 3, 4, 4, 5]

p single_non_duplicate nums