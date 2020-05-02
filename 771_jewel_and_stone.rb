require 'set'

# @param {String} j
# @param {String} s
# @return {Integer}
def num_jewels_in_stones(j, s)
  jewels = Set.new
  j.each_char do
    |jewel|
    jewels.add jewel
  end

  jewel_count = 0
  s.each_char do
    |stone|
    jewel_count += 1 if jewels.include? stone
  end

  jewel_count
end


J = "z"
S = "aAAbbbb"

p num_jewels_in_stones J, S