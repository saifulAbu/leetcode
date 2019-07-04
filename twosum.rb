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
	
	nums.each_with_index do
		|index, num|
		puts nums[index]
	end
end

two_sum [6, 7, 8, 9], 5



