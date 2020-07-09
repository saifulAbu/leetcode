# @param {Integer[]} cells
# @param {Integer} n
# @return {Integer[]}
def prison_after_n_days(cells, n)

end


=begin
size of the cells is fixed, r rows. n can be between 1 to 10 ^ 9
so content of cells will repeat.

def next_day cur

end

day = 0
cur = start_day
set.add cur
map.add(0, start_day)
while true
  day += 1
  cur = next_day cur
  break if set.include? cur
  set.add cur
  map.add(day, cur)
end

rep = day - 1
res_day = n % rep

return map.get(res_day)
=end