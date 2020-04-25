# @param {Integer[]} nums
# @return {Boolean}
def can_jump(nums)
  size = nums.size
  last_known_good = size - 1
  (size-2).downto(0) do
    |i|
    last_known_good = i if i + nums[i] >= last_known_good
  end

  last_known_good == 0
end

