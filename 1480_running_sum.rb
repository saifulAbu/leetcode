# @param {Integer[]} nums
# @return {Integer[]}
def running_sum(nums)
  return [] if nums.nil? or nums.empty?
  for i in (1..nums.size - 1) do
    nums[i] = nums[i] + nums[i-1]
  end
  nums
end

nums = [1]
p running_sum(nums)