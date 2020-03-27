# @param {String} s
# @param {Integer} num_rows
# @return {String}
def convert(s, num_rows)

end

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

=end


