# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Integer[]}
def intersect(nums1, nums2)
  res = []
  map = Hash.new() {0}

  nums1.each do
    |elem|
    map[elem] += 1
  end

  nums2.each do
    |elem|
    if map[elem] > 0
      map[elem] -= 1
      res << elem
    end
  end

  res
end

nums1 = [1,2,2,1]
nums2 = [2,2]

p intersect nums1, nums2