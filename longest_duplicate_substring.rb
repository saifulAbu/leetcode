require 'set'
#require 'pry'
#require 'pry-nav'

# @param {String} s
# @return {String}
def longest_dup_substring(s)
  h = s.size
  l = 1
  max_len = 0
  max_str = ""
  #binding.pry
  while l <= h do
    m = (h + l) / 2
    set = Set.new
    cur_hash = 0

    for i in (0..m-1)
      cur_hash = 26 * cur_hash + int_val(s[i])
    end
    #puts "cur_hash: #{cur_hash}"
    set.add(cur_hash)
    cur_len = 0
    cur_str = ""
    for i in (m..(s.size-1))
      cur_hash = (cur_hash - (26 ** (m-1)) * int_val(s[i-m])) * 26 + int_val(s[i])
      #puts "cur_hash: #{cur_hash}"
      if(set.include?(cur_hash))
        cur_len = m
        cur_str = s[(i-m+1..i)]
        break
      else
        set.add(cur_hash)
      end
    end

    if(cur_len > max_len)
      max_len = cur_len
      max_str = cur_str
      l = m + 1
    else
      h = m - 1
    end
  end

  max_str
end

def int_val(ch)
  return ch.ord - 'a'.ord + 1
end


p longest_dup_substring "axydxya"