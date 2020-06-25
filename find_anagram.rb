# @param {String} s
# @param {String} p
# @return {Integer[]}
def find_anagrams(s, p)
  res = []
  if s.size < p.size
    return res
  elsif s.size == p.size
    if s.eql? p
      return [0]
    else
      return []
    end
  end

  p_sum = 0
  p.each_char do
    |c|
    p_sum += c.ord
  end
  s_sum = 0
  for i in (0..(p.size - 1)) do
    s_sum += s[i].ord
  end

  i = 0
  j = p.size - 1

  begin
    res << i if s_sum == p_sum
    j += 1
    i += 1
    (s_sum = s_sum + s[j].ord - s[i-1].ord) if j < s.size
  end while j < s.size

  res
end

s = "dwtcaxzsnifvhmoueklpyq"
p = "yqrbgjdwtcaxzsnifvhmou"

p find_anagrams(s,p)