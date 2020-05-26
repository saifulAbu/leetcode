# @param {Integer} n
# @return {Integer}
def subtract_product_and_sum(n)
  digits = n.digits
  sum = digits.reduce(:+)
  product = digits.reduce(:*)
  product - sum
end
