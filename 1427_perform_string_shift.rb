require 'pry'
require 'pry-nav'

# @param {String} s
# @param {Integer[][]} shift
# @return {String}
def string_shift(s, shift)
  arr = s.split("")
  total_shift = 0
  shift.each do
    |shift_type, num_shift|
    if shift_type == 1
      total_shift += num_shift #right shift
    else
      total_shift -= num_shift
    end
  end

  if total_shift > 0
    total_shift = total_shift % arr.size
    res = right_shift(arr, total_shift)
    res.join
  elsif total_shift < 0
    total_shift = total_shift.abs % arr.size
    res = left_shift(arr, total_shift)
    res.join
  else
    s
  end
end

def right_shift(arr, num)
  #binding.pry
  size = arr.size
  first_part = arr[-1 * num, num]
  last_part = arr[0, size - num]
  first_part + last_part
end

def left_shift(arr, num)
  size = arr.size
  first_part = arr[-1 * (size-num), size - num]
  last_part = arr[0, num]
  first_part + last_part
  #binding.pry
end

p string_shift "abcdefg", [[1,1],[1,1],[0,2],[1,3]]

p left_shift("wpdhhcj".split(""), 4)


