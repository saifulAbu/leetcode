# @param {Integer[]} nums
# @param {Integer} k
# @return {Void} Do not return anything, modify nums in-place instead.
def rotate(nums, k)
  size = nums.size

  return nums if size < 2

  k =  k % size if k > size

  k.times do
    last = nums.delete_at(size - 1)
    nums.insert(0, last)
  end
  return nums
end

nums = [1, 2, 3, 4, 5, 6, 7]

p rotate(nums, 3)