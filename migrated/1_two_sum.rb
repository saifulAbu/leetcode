# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}

def two_sum(nums, target)
  num_map = Hash.new { |h, k| h[k] = [] }
  nums.each_with_index do
    |num, index|
    index_array = num_map[num]
    index_array.push(index)
    num_map[num] = index_array
  end

  nums.each do
    |num1|
    num2 = target - num1
    index_array1 = num_map[num1]
    index_array2 = num_map[num2]
    index_array_size = index_array2.size
    if num1 != num2
      if index_array_size > 0
        return [index_array1[0], index_array2[0]]
      end
    else
      if index_array_size > 1
        return [index_array1[0], index_array2[1]]
      end
    end
  end
  return []
end

#nums = [3, 6, 4]
#target = 10

#p two_sum(nums, target)