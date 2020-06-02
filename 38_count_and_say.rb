# @param {Integer} n
# @return {String}
def count_and_say(n)
  cur_str = "1"
  (n-1).times do
    i = 0
    cur_len = cur_str.size
    result = ""
    while i < cur_len do
      cur_digit = cur_str[i]
      count = 0
      while i < cur_len and cur_str[i] == cur_digit do
        count += 1
        i += 1
      end
      result = "#{result}#{count}#{cur_digit}"
    end
    cur_str = result
  end
  cur_str
end

p count_and_say 5