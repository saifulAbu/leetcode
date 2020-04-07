# @param {String[]} strs
# @return {String[][]}
def group_anagrams(strs)
  result_map = Hash.new { [] }

  strs.each do
    |word|
    sorted = word.chars.sort.join
    result_map[sorted] <<= word
  end

  result_map.values

end

p group_anagrams ["eat", "tea", "tan", "ate", "nat", "bat"]