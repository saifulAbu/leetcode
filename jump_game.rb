# @param {Integer[]} nums
# @return {Boolean}
def can_jump(nums)
  size = nums.size
  possible = Array.new(size) {false}
  possible[size-1] = true

  (size-2).downto(0) do
    |i|
    max_jump = nums[i]
    max_jump.downto(1) do
      |cur_jump|
      if (i + cur_jump >= (size - 1)) or (possible[i + cur_jump])
        possible[i] = true
        break
      end
    end
  end
  possible[0]
end
