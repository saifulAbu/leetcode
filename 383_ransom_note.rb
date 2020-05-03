# @param {String} ransom_note
# @param {String} magazine
# @return {Boolean}
def can_construct(ransom_note, magazine)
  ransom_map = Hash.new(){0}
  ransom_note.each_char do
    |ch|
    ransom_map[ch] += 1
  end

  magazine_map = Hash.new(){0}
  magazine.each_char do
    |ch|
    magazine_map[ch] += 1
  end

  ransom_map.keys.each do
    |key|
    return false if magazine_map[key] < ransom_map[key]
  end

  return true
end

p can_construct("a", "b")    #-> false
p can_construct("aa", "ab")  # -> false
p can_construct("aa", "aab") # -> true