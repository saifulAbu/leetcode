# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
  map = {}
  nums.each_with_index do
    |num1, i|
    num2 = target - num1
    if map[num2].nil?
      map[num1] = i
    else
      return [map[num2], i]
    end
  end
end

arr = [2, 1, 3, 2]
target = 4

p two_sum(arr, target)