# @param {String} haystack
# @param {String} needle
# @return {Integer}
def str_str(haystack, needle)
  return 0 if needle == ""

  return -1 if haystack.size < needle.size

  for i in (0..(haystack.size - needle.size)) do
    matched = true
    for j in (0..(needle.size - 1)) do
      if haystack[i+j] != needle[j]
        matched = false
        break
      end
    end
    return i if matched
  end

  return -1
end

haystack = "abcabcd"
needle = "abcd"
p str_str haystack, needle

