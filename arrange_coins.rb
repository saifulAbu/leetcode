# https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
# @param {Integer} n
# @return {Integer}
def arrange_coins(n)

end

=begin
general strategy
for given n, we need to find lower bound of the number
1+2+...+x = n
x * (x+1) = 2 * n
x = floor(sqrt(2 * n))

then if x * (x+1) > 2 * n return x - 1
else if x * (x + 1) <= 2 * n
        return x

=end