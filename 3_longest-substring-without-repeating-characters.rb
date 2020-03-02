# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
   string_size = s.size
   substr_size = Array.new(string_size, 0)

   (1..string_size).each do
    |cur_len|
    (0..(string_size-cur_len)) do
        |begin_index|
        end_index = begin_index + cur_len - 1
        previous_substr_size = substr_size[begin_index]
        if((previous_substr_size + 1) == cur_len)
            if(s[begin_index])
        end
    end
   end
end

str = "abcabcbb"

length_of_longest_substring str