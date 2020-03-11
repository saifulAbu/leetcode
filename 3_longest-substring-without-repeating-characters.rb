require 'set'

# @param {String} s
# @return {Integer}
def length_of_longest_substring(str)
  max_len = 0
  str_len = str.size
  for i in (0..(str_len-1)) do
    for j in ((i) .. (str_len - 1)) do
      cur_len = j - i + 1
      if cur_len > max_len
        if is_unique(str[i, cur_len])
          max_len = cur_len
        else
          break
        end
      end
    end
  end
  max_len
end

def is_unique(str)
  set = Set.new(str.chars)
  return true if set.size == str.size
  false
end


str = "abcabcbb"


puts length_of_longest_substring "bbb"