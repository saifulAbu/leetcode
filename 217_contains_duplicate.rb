require 'set'
# @param {Integer[]} nums
# @return {Boolean}

def contains_duplicate(nums)
  set = Set.new
  nums.each do
    |elem|
    return true if set.include? elem
    set.add elem
  end
  return false
end

nums = [1, 2, 3]

p contains_duplicate nums