require 'set'
# how many elements has x we have such that array contains x+1
# @param {Integer[]} arr
# @return {Integer}
def count_elements(arr)
  arr = arr.sort {|x,y| (y <=> x)}
  p arr
  set = Set.new
  count = 0
  arr.each do
    |elem|
    count += 1 if set.include? (elem + 1)
    set.add elem
  end
  return count
end
