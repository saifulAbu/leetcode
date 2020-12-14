# @param {Integer[]} nums
# @return {Integer}
def find_duplicate(nums)
  nums = nums.sort

  for i in (0..(nums.size - 2)) do
    if nums[i] == nums[i+1]
      duplicate = nums[i]
      break
    end
  end
  duplicate
end

nums = [2, 2,2 ,2]
p find_duplicate(nums)

