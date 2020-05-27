# @param {Integer[]} nums
# @return {Integer[]}
def smaller_numbers_than_current(nums)
    result = []
    nums.each do
      |num|
      count = 0
      nums.each do
        |num_compare|
        count += 1 if num > num_compare
      end
      result << count
    end
    result
end

nums = [8,1,2,2,3]
p smaller_numbers_than_current(nums)