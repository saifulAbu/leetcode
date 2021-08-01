# @param {Integer[]} nums
# @return {Integer[]}
def product_except_self(nums)
  result = [1]
  size = nums.size

  1.upto(size - 1) do
    |i|
    result.push(result[i-1] * nums[i - 1])
    #p result
  end

  r_mult = 1
  (size-2).downto(0) do
    |i|
    r_mult *= nums[i+1]
    result[i] = result[i] * r_mult
  end
end

product_except_self [1, 2, 3, 4, 5]