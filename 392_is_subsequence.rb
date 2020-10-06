# @param {String} s
# @param {String} t
# @return {Boolean}
def is_subsequence(s, t)
  sub_seq_index = 0
  for i in (0..(t.size-1))
    sub_seq_index +=1 if(s[sub_seq_index] == t[i])
    if sub_seq_index == s.size
      break
    end
  end
  sub_seq_index == s.size ? true : false
end

s = "a"
t = "gfggdgf"

puts is_subsequence(s, t)