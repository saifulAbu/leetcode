# @param {Integer[]} nums
# @return {Integer}
def majority_element(nums)
  counts = Hash.new(){0}
  majority_size = nums.size / 2

  nums.each do
    |elem|
    counts[elem] += 1
  end

  counts.keys.each do
    |key|
    count = counts[key]
    return key if count > majority_size
  end
end

elem = [1]
p majority_element elem
