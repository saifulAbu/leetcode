require 'set'

# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
	hashmap = {}
	nums.each_with_index do
		|index, num|
		hashmap[num] = index
	end
end
