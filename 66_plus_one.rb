# @param {Integer[]} digits
# @return {Integer[]}
def plus_one(digits)
  size = digits.size
  carry = 1
  (size-1).downto(0) do
    |i|
    cur_val = digits[i] + carry
    digit = cur_val % 10
    carry = cur_val / 10
    digits[i] = digit
    break if carry == 0
  end

  digits.insert(0, carry) if carry > 0
  digits
end

arr1 = [4,3,2,2]
arr2 = [9, 9, 9]
arr3 = [0]
arr4 = [9]
p plus_one arr4