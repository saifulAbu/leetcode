# @param {Integer[]} candies
# @param {Integer} extra_candies
# @return {Boolean[]}
def kids_with_candies(candies, extra_candies)
  max_candy = candies.max
  result = []
  candies.each do
    |candy|
    if candy + extra_candies >= max_candy
      result << true
    else
      result << false
    end
  end
  result
end

candies = [2,3,5,1,3]
extraCandies = 3

p kids_with_candies(candies, extraCandies)