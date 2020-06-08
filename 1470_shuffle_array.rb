# @param {Integer[]} nums
# @param {Integer} n
# @return {Integer[]}
def shuffle(nums, n)
  result = []
  for i in (0..(n-1)) do
    x = nums[i]
    y = nums[i+n]
    result << x << y
  end
  result
end

nums = [2,5,1,3,4,7]
n = 3

p shuffle(nums, n)