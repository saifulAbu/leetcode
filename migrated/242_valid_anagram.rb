# @param {String} s
# @param {String} t
# @return {Boolean}
def is_anagram(s, t)
  return false if s.size != t.size
  h1 = Hash.new() {0}
  h2 = Hash.new() {0}

  s.each_char do
    |ch|
    h1[ch] += 1
  end

  t.each_char do
    |ch|
    h2[ch] += 1
  end

  h1.keys.each do
    |key|
    return false if h1[key] != h2[key]
  end

  return true
end

s = "yx"
t = "xy"

p is_anagram s, t