# @param {String} str
# @return {Integer}
def my_atoi(str)
  num = 0
  sign = 1
  max = 2 ** 31 - 1
  min = -max - 1
  cur_index = 0

  while str[cur_index] == ' '
    cur_index += 1
  end

  if str[cur_index] == '-'
    sign = -1
    cur_index += 1
  elsif str[cur_index] == '+'
    cur_index += 1
  end

  while str[cur_index] =~ /[0-9]/
    digit = str[cur_index].ord - '0'.ord
    num = num * 10 + digit
    cur_index += 1
  end

  num = num * sign
  if num < min
    num = min
  elsif num > max
    num = max
  end

  return num
end


p my_atoi "-42 4193 with words"
