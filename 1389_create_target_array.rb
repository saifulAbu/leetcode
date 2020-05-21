# @param {Integer[]} nums
# @param {Integer[]} index
# @return {Integer[]}
def create_target_array(nums, index)
  result = []
  for i in (0..(nums.size-1)) do
    ind = index[i]
    val = nums[i]
    result.insert(ind, val)
  end
  result
end

nums = [0,1,2,3,4]
index = [0,1,2,2,1]

p create_target_array(nums, index)