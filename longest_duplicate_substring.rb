# @param {String} s
# @return {String}
def longest_dup_substring(s)
  h = s.size - 1
  l = 0
  max = 0
  while l <= h do
    m = (h + l) / 2
    map = {}
    cur_hash = 0

    for(i in (0..m-1))
      cur_hash = 26 * cur_hash + s[i]
    end
    map
  end
end

