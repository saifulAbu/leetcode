# @param {Integer[]} target
# @param {Integer[]} arr
# @return {Boolean}
def can_be_equal(target, arr)
  t_map = Hash.new(){0}
  target.each do
    |i|
    t_map[i] += 1
  end
  a_map = Hash.new(){0}
  arr.each do
    |i|
    a_map[i] += 1
  end

  t_map.keys.each do
    |k|
    return false if t_map[k] != a_map[k]
  end
  true
end

target = [3,7,9]
arr = [3,7,11]
p can_be_equal(target, arr)