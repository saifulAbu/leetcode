# @param {String} s
# @return {String}
def longest_palindrome(s)
  str_arr = s.chars

  size = str_arr.size
  max_len = 1
  max_start = 0

  #check for odd sized palindrome
  for i in (0..size-2)
    start_index = i - 1
    end_index = i + 1
    while start_index >= 0 and end_index <= size-1
      if str_arr[start_index] == str_arr[end_index]
        start_index -= 1
        end_index += 1
      else
        break
      end
    end
    start_index += 1
    end_index -= 1
    len = (end_index - start_index + 1)
    if(len > max_len)
      max_len = len
      max_start = start_index
    end
  end


  ## check for even length sized palindrome
  for i in (1..size-1)
    start_index = i - 1
    end_index = i
    end_offset_shifted = false
    while start_index >= 0 and end_index <= size-1
      if str_arr[start_index] == str_arr[end_index]
        start_index -= 1
        end_index += 1
        end_offset_shifted = true
      else
        break
      end
    end
    start_index += 1
    end_index -= 1 if end_offset_shifted
    len = (end_index - start_index + 1)
    if(len > max_len)
      max_len = len
      max_start = start_index
    end
  end
   s.slice max_start, max_len
end

puts longest_palindrome "bb"

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