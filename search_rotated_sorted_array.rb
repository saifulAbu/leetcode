# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer}
def search(nums, target)
  pivot = find_pivot_point nums
  s = 0
  e = nums.size - 1
  #puts "pivot: #{pivot}"
  #if s[0] < target and s[pivot-1]
  if pivot == 0 # array already sorted
    search_range(nums, target, s, e)
  elsif pivot == e #pivot is last element
    if target == nums[e]
      return e
    else
      search_range(nums, target, s, e-1)
    end
  else
    if nums[s] <= target and target <= nums[pivot-1]
      search_range(nums, target, s, pivot-1)
    else
      search_range(nums, target, pivot, e)
    end
  end
end

def search_range(nums, target, s, e)
  #puts "staart: #{s}, end: #{e}, target: #{target}"
  while s < e
    m = (s + e) / 2
    if nums[m] == target
      return m
    elsif target > nums[m]
      s = m + 1
    else
      e = m - 1
    end
  end

  return s if nums[s] == target
  return -1
end

def find_pivot_point(nums)
  s = 0
  e = nums.size - 1

  while s < e
    mid = (s + e) / 2
    if nums[s] > nums[mid]
      s += 1
      e = mid
    elsif nums[mid] > nums[e]
      s = mid + 1
    else
      break
    end
  end
  s
end

p search [4, 3], 3