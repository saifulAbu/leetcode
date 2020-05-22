# @param {Integer[]} nums
# @return {Integer}
def find_numbers(nums)
  count = 0
  nums.each do
    |i|
    count +=1 if i.digits.size.even?
  end
  count
end

nums = [12,345,2,6,7896]
p find_numbers(nums)
