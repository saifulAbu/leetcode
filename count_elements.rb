require 'set'

# @param {Integer[]} arr
# @return {Integer}
def count_elements(arr)
  arr = arr.sort {|x,y| (y <=> x)}
  p arr
  set = Set.new
  count = 0
  arr.each do
    |elem|
    count += 1if set.include? (elem + 1)
    set.add elem
  end
  return count
end
