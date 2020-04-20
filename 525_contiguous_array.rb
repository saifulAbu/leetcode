# @param {Integer[]} nums
# @return {Integer}
def find_max_length(nums)
  map = {}
  map[0] = -1
  score = 0
  max_len = 0
  nums.each_with_index do
    |elem, index|
    if elem == 0
      score -= 1
    else
      score += 1
    end
    if map[score].nil?
      map[score] = index
    else
      cur_max = index - map[score]
      max_len = cur_max if cur_max > max_len
    end
  end

  return max_len
end

p find_max_length [0, 1, 0, 0, 1, 0]