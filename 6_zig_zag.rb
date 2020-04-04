# @param {String} s
# @param {Integer} num_rows
# @return {String}
def convert(s, num_rows)
  return s if s.empty? or num_rows == 1

  str_len = s.size
  result_str = ""

  #generate first row
  step_size = 2 * num_rows - 2
  (0...str_len).step(step_size).each do |index|
    result_str << s[index]
  end

  go_down = true
  #generate intermediate rows
  (1...(num_rows-1)).each do |cur_row|
    cur_val = cur_row
    down_up_inc =  2 * (num_rows - cur_row - 1)
    up_down_inc = 2 * (cur_row)
    go_down_up = true
    while cur_val < str_len
      result_str << s[cur_val]
      #print cur_val, " "
      if go_down_up
        go_down_up = false
        cur_val = cur_val + down_up_inc
      else
        go_down_up = true
        cur_val = cur_val + up_down_inc
      end
    end
    #puts ""
  end

  #generate last row
  if str_len >= num_rows
    ((num_rows-1)...str_len).step(step_size).each do |index|
      result_str << s[index]
    end
  end

  result_str
end

puts convert("A", 1)

=begin
|0| |4| |8 |
|1|3|5|7|9 |
|2| |6| |10|

target sequence: |0 4 8 | 1 3 5 7 9 | 2 6 10|
notice line 0 and line 3 always has same gap for each element.

we can generate these two
step = (num_rows - 1) + (num_rows - 2) = 2 * num_rows - 2
for i = 0 i < max val
i = i + step

## more thoughts
create sequences for row 0

create sequences for in between rows

create sequences for NUM_ROWS - 1

=end