require 'pry'
require 'pry-nav'

# @param {Character[]} s
# @return {Void} Do not return anything, modify s in-place instead.
def reverse_string(s)
  max_index = s.size - 1
  for i in (0..(max_index/2)) do
    #binding.pry
    swap_index = max_index - i
    temp = s[swap_index]
    s[swap_index] = s[i]
    s[i] = temp
  end
  s
end

a = ["a", "b", "c", "d", "f"]
p reverse_string a