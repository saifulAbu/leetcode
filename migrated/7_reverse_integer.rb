# @param {Integer} num
# @return {Integer}
def reverse(num)
  multiply_factor = 1
  multiply_factor = -1 if num < 0

  max = (2 ** 31) - 1
  num = num.abs
  digits = num.digits
  res = 0

  digits.each do
    |digit|
    res = 10 * res + digit
  end

  res = 0 if res > max
  return res * multiply_factor
end

