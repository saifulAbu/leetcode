# @param {Integer[]} nums
# @return {Integer[]}
def decompress_rl_elist(nums)
  result = []
  0.step(nums.size-2, 2) do
    |i|
    freq = nums[i]
    val = nums[i+1]
    freq.times do
      result << val
    end
  end
  result
end

nums = [1,2,3,4]
p decompress_rl_elist nums