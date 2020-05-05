# @param {String} s
# @return {Integer}
def first_uniq_char(s)
  count = Hash.new(){0}
  s.each_char do
    |ch|
    count[ch] += 1
  end

  for i in (0..(s.size - 1)) do
    ch = s[i]
    return i if count[ch] == 1
  end

  return -1
end

s = "" #return 0.
p first_uniq_char s
s = "loveleetcode" #return 2.
p first_uniq_char s