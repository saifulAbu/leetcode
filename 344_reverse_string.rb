# @param {Character[]} s
# @return {Void} Do not return anything, modify s in-place instead.
def reverse_string(s)
   for i in (0..(s.size / 2 - 1))
    temp = s[i]
    s[i] = s[s.size - 1 - i]
    s[s.size - 1 - i] = temp
   end
   s
end

p reverse_string "123"