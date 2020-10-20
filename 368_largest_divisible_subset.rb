# @param {Integer[]} nums
# @return {Integer[]}
def largest_divisible_subset(nums)
  return [] if nums.empty?
  nums = nums.sort
  subset_size = Array.new(nums.size) {1}
  max_index = 0
  for i in (0..nums.size-1) do
    for j in (0..i - 1) do
      if(nums[i] % nums[j] == 0 and subset_size[j] + 1 > subset_size[i])
        subset_size[i] += 1
        if(subset_size[i] > subset_size[max_index])
          max_index = i
        end
      end
    end
  end


  cur_max = subset_size[max_index] - 1
  prev_max = nums[max_index]
  res = [] << prev_max
  (max_index-1).downto(0) do
    |i|
    if(subset_size[i] == cur_max && prev_max % nums[i] == 0)
      res << nums[i]
      cur_max -= 1
      prev_max = nums[i]
    end
  end

  p res
end

nums = [2,3,4,8]
largest_divisible_subset nums