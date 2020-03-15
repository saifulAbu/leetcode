# @param {String} s
# @return {String}
def longest_palindrome(s)

end

=begin
  max_palindromic_len = 1

  for each index i
    start_index = i-1
    end_index = i+1
    while start_index >= 0 and end_index <= len - 2
      if str[start_index] == str[end_index]
        start_index--
        end_index++
      else
        break
      end
    end
    start_index += 1
    end_index -= 1
    len = (end_index - start_index + 1)
    if len == 1
      if str[i] == str[i+1]
        end_index = i + 1
      end
    end
    if(len > max_len)
      max_len = len
      max_start = start_index
      max_end = end_index
    end
  end
=end


